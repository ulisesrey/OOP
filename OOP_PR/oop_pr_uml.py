from graphviz import Digraph

# Create a new directed graph
dot = Digraph(comment='Train Travel Management System')

# Define the classes and their attributes/methods
classes = {
    "Station": {
        "attributes": [
            "+id: String", "+name: String", "+city: String", "+openingYear: int",
            "+type: StationType", "+coordinates: Coordinates", "+imageFilename: String"
        ],
        "methods": [
            "+toString(): String"
        ]
    },
    "Train": {
        "attributes": [
            "+id: String", "+model: String", "+wagons: List<Wagon>"
        ],
        "methods": [
            "+getAvailableSeat(wagonClass: WagonClass): Seat"
        ]
    },
    "Passenger": {
        "attributes": [
            "+passport: String", "+firstName: String", "+lastName: String",
            "+birthDate: LocalDate", "+email: String"
        ],
        "methods": [
            "+validateEmail(): boolean"
        ]
    },
    "Route": {
        "attributes": [
            "+id: String", "+train: Train", "+stations: List<Station>",
            "+schedules: Map<Station, List<Schedule>>"
        ],
        "methods": [
            "+getSchedule(station: Station): List<Schedule>"
        ]
    },
    "Ticket": {
        "attributes": [
            "+passenger: Passenger", "+seat: Seat", "+price: double",
            "+departure: Schedule", "+arrival: Schedule"
        ],
        "methods": [
            "+calculatePrice(): double"
        ]
    },
    "Controller": {
        "attributes": [
            "+stations: List<Station>", "+routes: List<Route>",
            "+trains: List<Train>", "+passengers: Map<String, Passenger>",
            "+tickets: List<Ticket>"
        ],
        "methods": [
            "+loadStations(filename: String): void",
            "+loadTrains(filename: String): void",
            "+loadRoutes(filename: String): void",
            "+buyTicket(passenger: Passenger, route: Route, schedule: Schedule, seatType: SeatType): Ticket"
        ]
    }
}

# Add classes to the graph with HTML-like labels
for class_name, class_content in classes.items():
    attributes = "<BR/>".join(class_content["attributes"])
    methods = "<BR/>".join(class_content["methods"])
    label = f"<{class_name}|{{<B>Attributes</B>|{attributes}}}|{{<B>Methods</B>|{methods}}}>"
    dot.node(class_name, label=label, shape="record")

# Define relationships
relationships = [
    ("Route", "Train", "1", "1"),
    ("Route", "Station", "1", "1..*"),
    ("Train", "Wagon", "1", "1..*"),
    ("Wagon", "Seat", "1", "1..*"),
    ("Passenger", "Ticket", "1", "1..*"),
    ("Ticket", "Passenger", "1", "1"),
    ("Ticket", "Seat", "1", "1"),
    ("Ticket", "Schedule", "1", "1"),
    ("Schedule", "Station", "1", "1")
]

# Add relationships to the graph
for source, target, src_multiplicity, tgt_multiplicity in relationships:
    dot.edge(source, target, arrowhead="none", label=f"{src_multiplicity}..{tgt_multiplicity}")

# Render the UML class diagram to a file
uml_diagram_path = "train_travel_management_uml.png"
dot.render(uml_diagram_path, format="png")

uml_diagram_path + ".png"

USE VEHICOOLDB;

CREATE TABLE Customers(
                          CustomerId int NOT NULL PRIMARY KEY,
                          CustomerName varchar(50) NOT NULL,
                          Email varchar(50) NOT NULL,
                          PhoneNumber varchar(11) NOT NULL,
                          ProfilePicture varchar(20)
);

CREATE TABLE Cars(
                     CarId int NOT NULL PRIMARY KEY,
                     Make varchar(50) NOT NULL,
                     Model varchar(50) NOT NULL,
                     CarImage varchar(20),
                     CarLocation varchar(50) NOT NULL,
                     AvailabilityStart date NOT NULL,
                     AvailabilityEnd date NOT NULL,
                     Price smallmoney NOT NULL,
);

CREATE TABLE Rentals(
                        RentalId int NOT NULL PRIMARY KEY,
                        CustomerId int NOT NULL,
                        RentalStart date NOT NULL,
                        RentalEnd date NOT NULL,
                        FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),
);

CREATE TABLE CarsToRentals(
                              RentalId int NOT NULL,
                              CarId int NOT NULL,
                              PRIMARY KEY (RentalId, CarID),
                              FOREIGN KEY (CarId) REFERENCES Cars(CarId),
                              FOREIGN KEY (RentalId) REFERENCES Rentals(RentalId)
);

INSERT INTO Customers (CustomerId, CustomerName, Email, PhoneNumber, ProfilePicture)
Values (1, 'John Doe', 'johndoe@gmail.com', '11234567890', 'stockpfp1'),
       (2, 'Jane Doe', 'janedoe@gmail.com', '11234567890', 'stockpfp2'),
       (3, 'Jace Doe', 'jacedoe@gmail.com', '11234567890', 'stockpfp3')
INSERT INTO Cars (CarId, Make, Model, CarImage, CarLocation, AvailabilityStart, AvailabilityEnd, Price)
Values (1, 'Rubus', 'Tructa Saxum', 'stockcar1', 'Cincinnati, OH', '2023-09-05', '2023-10-05', 3.00),
       (2, 'Rubus', 'Hippurus Marmor', 'stockcar2', 'Cincinnati, OH', '2023-09-05', '2023-10-05', 179000.00),
       (3, 'Caecus', 'Tellus Maximus 9000', 'stockcar3', 'Cincinnati, OH', '2023-10-01', '2023-12-31', 300.00),
       (4, 'Caecus', 'Vitrum Glomerorum', 'stockcar4', 'Cincinnati, OH', '2024-02-04', '2025-02-08', 400.00)
INSERT INTO Rentals (RentalId, CustomerId, RentalStart, RentalEnd)
Values (1, 1, '2023-09-05', '2023-10-05'),
       (2, 2, '2023-10-01', '2023-10-05'),
       (3, 3, '2024-02-04', '2025-02-06')
INSERT INTO CarsToRentals (RentalId, CarId)
Values (1, 1),
       (1, 2),
       (2, 3),
       (3, 4)
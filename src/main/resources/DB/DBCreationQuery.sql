USE VEHICOOLDB;

CREATE TABLE Companies(
                          CompanyId int NOT NULL PRIMARY KEY,
                          CompanyName varchar(50) NOT NULL,
                          Email varchar(50) NOT NULL,
                          PhoneNumber varchar(11) NOT NULL,
                          ProfilePicture varchar(20),
);

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
                     CarYear int NOT NULL,
                     CarImage varchar(20),
                     NumPassengers int NOT NULL,
                     CarLocation varchar(50) NOT NULL,
                     CarDimensions varchar(50),
                     AvailabilityStart date NOT NULL,
                     AvailabilityEnd date NOT NULL,
                     Price smallmoney NOT NULL,
                     CompanyId int NOT NULL,
                     FOREIGN KEY (CompanyId) REFERENCES Companies(CompanyId)
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

INSERT INTO Companies (CompanyId, CompanyName, Email, PhoneNumber, ProfilePicture)
Values (1, 'RentalAgency1', 'rentalagency1@gmail.com', '11234567890', 'stockpfp1'),
       (2, 'RentalAgency2', 'rentalagency2@gmail.com', '11234567890', 'stockpfp2');
INSERT INTO Customers (CustomerId, CustomerName, Email, PhoneNumber, ProfilePicture)
Values (1, 'John Doe', 'johndoe@gmail.com', '11234567890', 'stockpfp1'),
       (2, 'Jane Doe', 'janedoe@gmail.com', '11234567890', 'stockpfp2'),
       (3, 'Jace Doe', 'jacedoe@gmail.com', '11234567890', 'stockpfp3')
    INSERT INTO Cars (CarId, Make, Model, CarYear, CarImage, NumPassengers, CarLocation, CarDimensions, AvailabilityStart, AvailabilityEnd, Price, CompanyId)
Values (1, 'Rubus', 'Tructa Saxum', 1982, 'stockcar1', 3, 'Cincinnati, OH', '20 x 10 x 5', '2023-09-05', '2023-10-05', 3.00, 1),
    (2, 'Rubus', 'Hippurus Marmor', 1389, 'stockcar2', 4, 'Cincinnati, OH', '25 x 15 x 5', '2023-09-05', '2023-10-05', 179000.00, 1),
    (3, 'Caecus', 'Tellus Maximus 9000', 2020, 'stockcar3', 5, 'Cincinnati, OH', '20 x 15 x 6', '2023-10-01', '2023-12-31', 300.00, 2),
    (4, 'Caecus', 'Vitrum Glomerorum', 2021, 'stockcar4', 5, 'Cincinnati, OH', '25 x 15 x 5', '2024-02-04', '2025-02-08', 400.00, 2)
INSERT INTO Rentals (RentalId, CustomerId, RentalStart, RentalEnd)
Values (1, 1, '2023-09-05', '2023-10-05'),
    (2, 2, '2023-10-01', '2023-10-05'),
    (3, 3, '2024-02-04', '2025-02-06')
INSERT INTO CarsToRentals (RentalId, CarId)
Values (1, 1),
    (1, 2),
    (2, 3),
    (3, 4)
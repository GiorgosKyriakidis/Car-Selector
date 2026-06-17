-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 18 Ιουν 2026 στις 00:04:47
-- Έκδοση διακομιστή: 10.4.32-MariaDB
-- Έκδοση PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `cars`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `history`
--

CREATE TABLE `history` (
  `brand` varchar(32) NOT NULL,
  `model` varchar(32) NOT NULL,
  `timestamp` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Άδειασμα δεδομένων του πίνακα `history`
--



--
-- Δομή πίνακα για τον πίνακα `models`
--

CREATE TABLE `models` (
  `brand` varchar(32) NOT NULL,
  `model` varchar(32) NOT NULL,
  `image` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Άδειασμα δεδομένων του πίνακα `models`
--

INSERT INTO `models` (`brand`, `model`, `image`) VALUES
('Nissan', 'Sunny', 'https://www.autogreeknews.gr/wp-content/uploads/2020/09/Nissan-Sunny-1981-B11-1.jpg'),
('Toyota', 'Auris', 'https://upload.wikimedia.org/wikipedia/commons/6/6d/Toyota_Auris_5dr._front.jpg'),
('Toyota', 'Aygo', 'https://www.stock-center.gr/sites/default/files/styles/car_listing/public/car/2021-06/AYGO%20AUTO%201.jpg?itok=llS6-EvV'),
('Toyota', 'Corolla', 'https://s1.cdn.autoevolution.com/images/gallery/TOYOTACorolla-5doors--623_5.jpg'),
('Toyota', 'Yaris', 'https://www.autogreeknews.gr/wp-content/uploads/2022/03/Toyota-Yaris-GR-Sport.jpg'),
('VW', 'Golf', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Volkswagen_Golf_VIII_IMG_3829.jpg/1920px-Volkswagen_Golf_VIII_IMG_3829.jpg'),
('VW', 'Polo', 'https://www.allcarphotos.net/wp-content/uploads/2020/09/VW-Polo-2021-01.jpg');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `models`
--
ALTER TABLE `models`
  ADD PRIMARY KEY (`brand`,`model`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

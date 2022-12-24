-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 02 Ara 2022, 13:09:38
-- Sunucu sürümü: 10.4.21-MariaDB
-- PHP Sürümü: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `Odev2`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `Havalimanları`
--

CREATE TABLE `Havalimanları` (
  `HavalimaniAdi` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Ulke` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `Sehir` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `Havalimanları`
--

INSERT INTO `Havalimanları` (`HavalimaniAdi`, `Ulke`, `Sehir`) VALUES
('Sabiha Gokcen', 'Turkiye', 'Istanbul'),
('Ataturk', 'Turkiye', 'Istanbul'),
('Esenboga', 'Turkiye', 'Ankara'),
('Erzurum', 'Turkiye', 'Erzurum'),
('yenisehir', 'turkiye', 'bursa'),
('Trabzon', 'Turkiye', 'Trabzon');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `HavayoluSirketleri`
--

CREATE TABLE `HavayoluSirketleri` (
  `id` int(11) NOT NULL,
  `HavayoluSirketiAdi` text COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `HavayoluSirketleri`
--

INSERT INTO `HavayoluSirketleri` (`id`, `HavayoluSirketiAdi`) VALUES
(1, 'Turk Hava Yollari'),
(2, 'Pegasus'),
(3, 'Anadolu Jet'),
(4, 'SunExpress'),
(5, 'Emirates'),
(6, 'ItalyFly'),
(7, 'Allein');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `Kisiler`
--

CREATE TABLE `Kisiler` (
  `kisiTc` bigint(20) NOT NULL,
  `adSoyad` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `dogumTarihi` date NOT NULL,
  `Kategori` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `Kisiler`
--

INSERT INTO `Kisiler` (`kisiTc`, `adSoyad`, `dogumTarihi`, `Kategori`) VALUES
(18876545643, 'Ayse Temel', '2000-10-16', 'Yolcu'),
(28876545643, 'Tarik Aksoy', '1965-10-31', 'Yolcu'),
(56876545643, 'Erkan Ozer', '1986-08-29', 'Yonetici'),
(59876545643, 'Ezgi Seker', '1957-04-04', 'Yolcu'),
(63876545643, 'Ahmet Bozkurt', '1960-06-04', 'Yonetici'),
(75876545643, 'Sevde Çalık', '1990-04-06', 'Kabin Uyesi'),
(78816545643, 'Gonca Ekrem', '1987-10-31', 'Yolcu'),
(78876145643, 'Sibel Celik', '1989-04-05', 'Kabin Uyesi'),
(98876445643, 'Sevda Dogan', '1986-06-25', 'Yolcu');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `rezYap`
--

CREATE TABLE `rezYap` (
  `yolcuNo` int(11) NOT NULL,
  `kisiTc` bigint(20) NOT NULL,
  `yolcuAdSoyad` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `rezervasyonNo` int(11) NOT NULL,
  `ucusSaati` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `kalkisHavalimani` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `varisHavalimani` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `ucusNo` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `koltukNo` int(11) NOT NULL,
  `sinif` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `ucret` int(11) NOT NULL,
  `durum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `Uçaklar`
--

CREATE TABLE `Uçaklar` (
  `Tip` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `Kapasite` int(11) NOT NULL,
  `uretimYili` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `Uçaklar`
--

INSERT INTO `Uçaklar` (`Tip`, `Kapasite`, `uretimYili`) VALUES
('Airbus A319', 155, 2020),
('Airbus A320', 200, 2010),
('Airbus A330', 225, 2009),
('Boeing 737', 200, 2022),
('A129 Boeing', 240, 2022);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uçuşlar`
--

CREATE TABLE `uçuşlar` (
  `ucusNo` int(11) NOT NULL,
  `ucusTarihi` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `ucusSuresi` int(11) NOT NULL,
  `KalkisKonum` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `KalkisHavalimani` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `VarisKonum` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `VarisHavalimani` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `UcakTipi` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `HavayoluSirketi` text COLLATE utf8mb4_turkish_ci NOT NULL,
  `Durum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `uçuşlar`
--

INSERT INTO `uçuşlar` (`ucusNo`, `ucusTarihi`, `ucusSuresi`, `KalkisKonum`, `KalkisHavalimani`, `VarisKonum`, `VarisHavalimani`, `UcakTipi`, `HavayoluSirketi`, `Durum`) VALUES
(1, '2021-07-12', 60, 'Turkiye/Istanbul', 'Sabiha Gokcen', 'Turkiye/Ankara', 'Esenboga', 'Airbus A319', 'Pegasus', 4),
(2, '2022-11-12', 60, 'Turkiye/Istanbul', 'Sabiha Gokcen', 'Turkiye/Ankara', 'Esenboga', 'Airbus A320', 'Turk Hava Yolları', 1),
(3, '2022-11-15', 60, 'Turkiye/Istanbul', 'Sabiha Gokcen', 'Turkiye/Ankara', 'Esenboga', 'Airbus A319', 'SunExpress', 3),
(4, '2022-06-15', 70, 'Turkiye/Erzurum', 'Erzurum Havalimanı', 'Turkiye/Ankara', 'Esenboga', 'Boeing 737', 'Anadolu Jet', 2),
(5, '2022-12-05', 50, 'Turkiye/Bursa', 'Yenisehir', 'Turkiye/Erzurum', 'Erzurum', 'Airbus A319', 'Anadolu Jet', 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `HavayoluSirketleri`
--
ALTER TABLE `HavayoluSirketleri`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `Kisiler`
--
ALTER TABLE `Kisiler`
  ADD UNIQUE KEY `kisiTc` (`kisiTc`);

--
-- Tablo için indeksler `rezYap`
--
ALTER TABLE `rezYap`
  ADD PRIMARY KEY (`yolcuNo`);

--
-- Tablo için indeksler `uçuşlar`
--
ALTER TABLE `uçuşlar`
  ADD PRIMARY KEY (`ucusNo`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `HavayoluSirketleri`
--
ALTER TABLE `HavayoluSirketleri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Tablo için AUTO_INCREMENT değeri `rezYap`
--
ALTER TABLE `rezYap`
  MODIFY `yolcuNo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `uçuşlar`
--
ALTER TABLE `uçuşlar`
  MODIFY `ucusNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO units (id, name) VALUES ('d2c1848e-5c92-4d0b-83a7-6d8e1e1e6aeb', 'Lake House');
INSERT INTO units (id, name) VALUES ('1e5e9d5c-61e9-4a6d-a7fc-8ad42e679a2a', 'Downtown Party House');
INSERT INTO units (id, name) VALUES ('4f53a437-9ff7-4375-a4a7-93dbf67839e2', 'Mountain Retreat');
INSERT INTO units (id, name) VALUES ('9deaa0c1-19b2-4d08-9a6b-08be38d74639', 'Seaside Villa');
INSERT INTO units (id, name) VALUES ('c14c13b6-36a1-4c23-95e4-cd53be01d74e', 'Rustic Cabin');
INSERT INTO units (id, name) VALUES ('71960f77-7f77-42f9-8a53-f0f2b63f4963', 'Luxury Penthouse');
INSERT INTO units (id, name) VALUES ('e331245d-eb76-4d5c-b1a6-2d301d85c515', 'Countryside Farmhouse');
INSERT INTO units (id, name) VALUES ('7a3e9eab-0b95-4b85-b305-7a97c64b5720', 'City View Apartment');
INSERT INTO units (id, name) VALUES ('b8b641f0-35db-480d-bc4f-4e92840c218a', 'Beachfront Bungalow');
INSERT INTO units (id, name) VALUES ('4c1a14b2-6b9f-4210-a32a-7b30aeb46ed7', 'Cozy Cottage');
INSERT INTO units (id, name) VALUES ('33ef1f2c-1f6f-4e61-9be7-00ff08078983', 'Urban Loft');
INSERT INTO units (id, name) VALUES ('979cd7ae-2c02-49a4-866f-76a68ac7aeb3', 'Historic Manor');
INSERT INTO units (id, name) VALUES ('82efc155-4b5a-459f-8e1e-27e35eae1be2', 'Modern Townhouse');
INSERT INTO units (id, name) VALUES ('d5a5f4c6-781b-4ad9-b4a6-9ee85d8c5e3e', 'Ski Chalet');
INSERT INTO units (id, name) VALUES ('1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', 'Waterfront Estate');



INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('ee30de22-29f6-4bc2-a7c1-26123628d8ff', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-06-17', '2023-06-18', 1, '2023-06-17 08:00:00', '2023-06-17 08:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('2a4a1e9e-d5c6-4a2c-b4bc-52e3b1ebe8ab', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-06-18', '2023-06-20', 2, '2023-06-18 10:00:00', '2023-06-18 10:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('f8d6d5ef-27c0-4d8f-bff9-75b6b57052d3', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-06-20', '2023-06-25', 5, '2023-06-20 13:00:00', '2023-06-20 13:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('ef8008df-18c2-487b-b6c1-2e6d94419784', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-06-22', '2023-06-24', 2, '2023-06-21 20:00:00', '2023-06-21 20:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('6148d64d-2272-4c71-b3e4-3bbcffa87007', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-06-25', '2023-06-27', 2, '2023-06-24 12:00:00', '2023-06-24 12:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('0de90b77-dfb6-4c17-8baf-44b6f93dd5e3', 'b8b641f0-35db-480d-bc4f-4e92840c218a', '2023-06-27', '2023-06-30', 3, '2023-06-26 18:00:00', '2023-06-26 18:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('c6cde5f3-15d4-4c18-a91a-1e4b2fe36c2d', 'b8b641f0-35db-480d-bc4f-4e92840c218a', '2023-06-29', '2023-07-03', 4, '2023-06-28 10:00:00', '2023-06-28 10:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('137d4a70-4a83-4124-94db-9bc3d4c51fa5', '7a3e9eab-0b95-4b85-b305-7a97c64b5720', '2023-07-02', '2023-07-07', 5, '2023-07-01 20:00:00', '2023-07-01 20:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('3b8d4f1e-4e9b-4875-86e2-58e49240b32b', '7a3e9eab-0b95-4b85-b305-7a97c64b5720', '2023-07-05', '2023-07-10', 5, '2023-07-04 12:00:00', '2023-07-04 12:00:00');

INSERT INTO bookings (id, unit_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('d2c1848e-5c92-4d0b-83a7-6d8e1e1e6aeb', '7a3e9eab-0b95-4b85-b305-7a97c64b5720', '2023-07-08', '2023-07-12', 4, '2023-07-07 18:00:00', '2023-07-07 18:00:00');


INSERT INTO unit_block_times (id, unit_id, start_time, end_time, reason, block_status, updated_at)
    VALUES ('ed62c458-dee1-4dc2-a496-1e0e0a3b48bf', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-09-17', '2023-09-18', 'A/C maintenance', 'ACTIVE', '2023-06-17 08:00:00');
INSERT INTO unit_block_times (id, unit_id, start_time, end_time, reason, block_status, updated_at)
    VALUES ( '15a954a3-efce-4f08-a5f1-88f90d5b7b5c','1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-08-17', '2023-08-18', 'A/C maintenance', 'ACTIVE', '2023-06-17 08:00:00');
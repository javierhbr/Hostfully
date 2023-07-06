INSERT INTO units (id, host_id, name) VALUES ('d2c1848e-5c92-4d0b-83a7-6d8e1e1e6aeb', '9ac1066b-cc27-4c63-ac9e-31342776c851', 'Lake House');
INSERT INTO units (id, host_id, name) VALUES ('1e5e9d5c-61e9-4a6d-a7fc-8ad42e679a2a', '9ac1066b-cc27-4c63-ac9e-31342776c851', 'Downtown Party House');
INSERT INTO units (id, host_id, name) VALUES ('4f53a437-9ff7-4375-a4a7-93dbf67839e2', '9ac1066b-cc27-4c63-ac9e-31342776c851', 'Mountain Retreat');
INSERT INTO units (id, host_id, name) VALUES ('9deaa0c1-19b2-4d08-9a6b-08be38d74639', 'b81f02cf-975b-49ab-83c1-fea533e5aba5', 'Seaside Villa');
INSERT INTO units (id, host_id, name) VALUES ('c14c13b6-36a1-4c23-95e4-cd53be01d74e', 'b81f02cf-975b-49ab-83c1-fea533e5aba5', 'Rustic Cabin');
INSERT INTO units (id, host_id, name) VALUES ('71960f77-7f77-42f9-8a53-f0f2b63f4963', 'bc37c9ef-d09f-4495-901e-077cac212fa3', 'Luxury Penthouse');
INSERT INTO units (id, host_id, name) VALUES ('e331245d-eb76-4d5c-b1a6-2d301d85c515', 'bc37c9ef-d09f-4495-901e-077cac212fa3', 'Countryside Farmhouse');
INSERT INTO units (id, host_id, name) VALUES ('7a3e9eab-0b95-4b85-b305-7a97c64b5720', 'a6d02180-c161-4229-8342-d4afd9073316', 'City View Apartment');
INSERT INTO units (id, host_id, name) VALUES ('b8b641f0-35db-480d-bc4f-4e92840c218a', 'a6d02180-c161-4229-8342-d4afd9073316', 'Beachfront Bungalow');
INSERT INTO units (id, host_id, name) VALUES ('4c1a14b2-6b9f-4210-a32a-7b30aeb46ed7', 'a6d02180-c161-4229-8342-d4afd9073316', 'Cozy Cottage');
INSERT INTO units (id, host_id, name) VALUES ('33ef1f2c-1f6f-4e61-9be7-00ff08078983', '252c7811-2aff-47f6-a17a-32b6213faed7', 'Urban Loft');
INSERT INTO units (id, host_id, name) VALUES ('979cd7ae-2c02-49a4-866f-76a68ac7aeb3', '252c7811-2aff-47f6-a17a-32b6213faed7', 'Historic Manor');
INSERT INTO units (id, host_id, name) VALUES ('82efc155-4b5a-459f-8e1e-27e35eae1be2', '252c7811-2aff-47f6-a17a-32b6213faed7', 'Modern Townhouse');
INSERT INTO units (id, host_id, name) VALUES ('d5a5f4c6-781b-4ad9-b4a6-9ee85d8c5e3e', '75933063-5afb-4ebf-85c1-e39d78a98cf7', 'Ski Chalet');
INSERT INTO units (id, host_id, name) VALUES ('1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '75933063-5afb-4ebf-85c1-e39d78a98cf7', 'Waterfront Estate');



INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('ee30de22-29f6-4bc2-a7c1-26123628d8ff', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '9ac1066b-cc27-4c63-ac9e-31342776c851' ,'1fd7bba7-eef5-4c14-bf95-495a0e2bb04b', '2023-06-17', '2023-06-18', 1, '2023-06-17 08:00:00', '2023-06-17 08:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('2a4a1e9e-d5c6-4a2c-b4bc-52e3b1ebe8ab', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', 'b81f02cf-975b-49ab-83c1-fea533e5aba5' ,'57a3d914-648c-4b55-939f-037018b43e87', '2023-06-18', '2023-06-20', 2, '2023-06-18 10:00:00', '2023-06-18 10:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('f8d6d5ef-27c0-4d8f-bff9-75b6b57052d3', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '9ac1066b-cc27-4c63-ac9e-31342776c851' ,'1fd7bba7-eef5-4c14-bf95-495a0e2bb04b', '2023-06-20', '2023-06-25', 5, '2023-06-20 13:00:00', '2023-06-20 13:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('ef8008df-18c2-487b-b6c1-2e6d94419784', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', 'b81f02cf-975b-49ab-83c1-fea533e5aba5' ,'57a3d914-648c-4b55-939f-037018b43e87', '2023-06-22', '2023-06-24', 2, '2023-06-21 20:00:00', '2023-06-21 20:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('6148d64d-2272-4c71-b3e4-3bbcffa87007', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '9ac1066b-cc27-4c63-ac9e-31342776c851' ,'1fd7bba7-eef5-4c14-bf95-495a0e2bb04b', '2023-06-25', '2023-06-27', 2, '2023-06-24 12:00:00', '2023-06-24 12:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('0de90b77-dfb6-4c17-8baf-44b6f93dd5e3', 'b8b641f0-35db-480d-bc4f-4e92840c218a', 'bc37c9ef-d09f-4495-901e-077cac212fa3' ,'c1ff6f92-adc4-4909-aa64-4ded58507e25', '2023-06-27', '2023-06-30', 3, '2023-06-26 18:00:00', '2023-06-26 18:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('c6cde5f3-15d4-4c18-a91a-1e4b2fe36c2d', 'b8b641f0-35db-480d-bc4f-4e92840c218a', 'a6d02180-c161-4229-8342-d4afd9073316' ,'e77bee85-e43c-44b5-98d0-bec9e663b0f8', '2023-06-29', '2023-07-03', 4, '2023-06-28 10:00:00', '2023-06-28 10:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('137d4a70-4a83-4124-94db-9bc3d4c51fa5', '7a3e9eab-0b95-4b85-b305-7a97c64b5720', '252c7811-2aff-47f6-a17a-32b6213faed7' ,'c0c590e2-739d-4f42-8fd9-ff677fd16796', '2023-07-02', '2023-07-07', 5, '2023-07-01 20:00:00', '2023-07-01 20:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('3b8d4f1e-4e9b-4875-86e2-58e49240b32b', '7a3e9eab-0b95-4b85-b305-7a97c64b5720', '75933063-5afb-4ebf-85c1-e39d78a98cf7' ,'0e8e286e-ff7d-42f6-b301-0070ddcc6c07', '2023-07-05', '2023-07-10', 5, '2023-07-04 12:00:00', '2023-07-04 12:00:00');

INSERT INTO bookings (id, unit_id, host_id, guest_id, start_time, end_time, total_nights, created_at, updated_at)
VALUES ('d2c1848e-5c92-4d0b-83a7-6d8e1e1e6aeb', '7a3e9eab-0b95-4b85-b305-7a97c64b5720', '9ac1066b-cc27-4c63-ac9e-31342776c851' ,'1fd7bba7-eef5-4c14-bf95-495a0e2bb04b', '2023-07-08', '2023-07-12', 4, '2023-07-07 18:00:00', '2023-07-07 18:00:00');


INSERT INTO unit_block_times (id, unit_id, start_time, end_time, reason, block_status, updated_at)
    VALUES ('ed62c458-dee1-4dc2-a496-1e0e0a3b48bf', '1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-09-17', '2023-09-18', 'A/C maintenance', 'ACTIVE', '2023-06-17 08:00:00');
INSERT INTO unit_block_times (id, unit_id, start_time, end_time, reason, block_status, updated_at)
    VALUES ( '15a954a3-efce-4f08-a5f1-88f90d5b7b5c','1c3a31d2-bb01-4ad4-8a78-7737c0abca7f', '2023-08-17', '2023-08-18', 'A/C maintenance', 'ACTIVE', '2023-06-17 08:00:00');
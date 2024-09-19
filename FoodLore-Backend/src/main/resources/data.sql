INSERT INTO Food (name, description, likes, dislikes, image_url) VALUES
     ('Dosa', 'Dosa', 30, 0, 'https://i.postimg.cc/wvWyGF7r/dosa.jpg'),
     ('Beef Steak', 'Beef Steak', 70, 0, 'https://i.postimg.cc/zXhvCqS6/beef-steak.jpg'),
     ('Burger', 'Burger', 100, 0, 'https://i.postimg.cc/dVK1ng51/burger.jpg'),
     ('Chicken Biriyani', 'Chicken Biriyani', 200, 0, 'https://i.postimg.cc/pLYdSkSB/chicken-biriyani.jpg'),
     ('French Fries', 'French Fries', 150, 0, 'https://i.postimg.cc/3RP4hNFj/french-fries.jpg'),
     ('Fuchka', 'Fuchka', 300, 0, 'https://i.postimg.cc/L5Lq8Sxc/fuchka.jpg'),
     ('Momo', 'Momo', 100, 0, 'https://i.postimg.cc/66v40VBM/momo.jpg'),
     ('Pasta', 'Pasta', 150, 0, 'https://i.postimg.cc/vHwgS1Bb/pasta.jpg'),
     ('Pizza', 'Pizza', 200, 0, 'https://i.postimg.cc/CLCByFBD/pizza.jpg'),
     ('Singara', 'Singara', 300, 0, 'https://i.postimg.cc/HkpJdfXN/singara.jpg'),
     ('Sushi', 'Sushi', 50, 0, 'https://i.postimg.cc/tgJYVWrt/sushi.jpg'),
     ('Tacos', 'Tacos', 200, 0, 'https://i.postimg.cc/q7FgcqSf/tacos.jpg');

INSERT INTO authority_table
VALUES(1, 'ROLE_ADMIN');

INSERT INTO authority_table
VALUES(2, 'ROLE_USER');

INSERT INTO user_table (user_id, first_name, last_name, username, password)
VALUES(101L, 'Minhajul', 'Islam', 'wrench', 'iamadmin');

INSERT INTO user_table (user_id, first_name, last_name, username, password)
VALUES(102L, 'Sanzida', 'Sultana', 'SanzidaSultana', 'iamuser');

INSERT INTO user_authority (user_id, authority_id)
VALUES(101L, 1);

INSERT INTO user_authority (user_id, authority_id)
VALUES(101L, 2);

INSERT INTO user_authority (user_id, authority_id)
VALUES(102L, 2);
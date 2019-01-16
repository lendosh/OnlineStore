create sequence hibernate_sequence start 1 increment 1;

create table item (
    id int8 not null,
    filename varchar(255),
    in_stock boolean not null,
    item_name varchar(255) not null,
    item_price numeric(19, 2) not null,
    user_id int8 not null,
    primary key (id)
);

create table order_role (
    user_id int8 not null,
    orders_id int8 not null,
    primary key (user_id, orders_id)
);

create table order_item (
    amount int4 not null,
    purchase_price numeric(19, 2),
    id_id int8 not null,
    item_id int8,
    orderitem_id int8,
    primary key (id_id)
);

create table orders (
    id int8 not null,
    creation_time timestamp,
    user_id int8 not null,
    primary key (id)
);

create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

create table usr (
    id int8 not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255),
    login varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

alter table if exists order_role
    add constraint UK_3tqssrhwcbicjprhlymh22621
    unique (orders_id);

alter table if exists item
    add constraint item_user_fk
    foreign key (user_id) references usr;

alter table if exists order_role
    add constraint FK1v55ysxokvtixtchkivmgqys
    foreign key (orders_id) references orders;

alter table if exists order_role
    add constraint FK37tx0e8e0ut29msv705rx7vlm
    foreign key (user_id) references usr;

alter table if exists order_item
    add constraint FKsd4sxk63dsd6syxli5mwfn7gu
    foreign key (id_id) references orders;

alter table if exists order_item
    add constraint FKija6hjjiit8dprnmvtvgdp6ru
    foreign key (item_id) references item;

alter table if exists order_item
    add constraint FK73dd17hbxing9wk0gkd2jcjku
    foreign key (orderitem_id) references orders;

alter table if exists orders
    add constraint FK7ncuqw9n77odylknbo8aikc9w
    foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;
create sequence hibernate_sequence
;

create table region
(
	id serial not null
		constraint region_pkey
			primary key,
	name varchar
)
;

create table place_type
(
	id serial not null
		constraint place_type_pkey
			primary key,
	place_type varchar
)
;

create table place_tag
(
	id serial not null
		constraint place_tag_pkey
			primary key,
	name varchar,
	type_id integer
		constraint place_tag_place_type_id_fk
			references place_type
)
;

create table place
(
	id serial not null
		constraint place_pkey
			primary key,
	name varchar,
	description varchar(200),
	region_id integer
		constraint place_region_id_fk
			references region,
	tag_id integer
		constraint place_place_tag_id_fk
			references place_tag,
	lat double precision,
	lon double precision,
	contacts varchar,
	link varchar
)
;

create unique index place_id_uindex
	on place (id)
;

create table photo
(
	id serial not null
		constraint photo_pkey
			primary key,
	image_path varchar,
	place_id integer
		constraint photo_place_id_fk
			references place
)
;

create table "user"
(
	id serial not null
		constraint user_pkey
			primary key,
	username varchar,
	login varchar(12),
	password varchar(20),
	email varchar,
	user_id bigint
)
;

create table comment
(
	id serial not null
		constraint comment_id_pk
			primary key,
	description varchar(200),
	place_id integer
		constraint comment_place_id_fk
			references place,
	rate_value integer,
	user_id integer
		constraint comment_user_id_fk
			references "user"
)
;

create unique index user_id_uindex
	on "user" (id)
;


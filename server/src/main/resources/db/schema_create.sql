create table app_language (id nvarchar(255) not null, active bit not null, created_date datetime not null, deleted bit not null, last_modified_date datetime, origin nvarchar(255) not null, sort_order integer, version bigint not null, country nvarchar(2) not null, language nvarchar(2) not null, attribute_type nvarchar(255) not null, created_by_id bigint, last_modified_by_id bigint, primary key (id)) engine=InnoDB;
create table app_language_l10n (id bigint not null, created_date datetime not null, language_code nvarchar(255) not null, last_modified_date datetime, type nvarchar(255) not null, value nvarchar(2000) not null, version bigint not null, created_by_id bigint, last_modified_by_id bigint, attribute nvarchar(255), primary key (id)) engine=InnoDB;
create table app_permission (id nvarchar(255) not null, active bit not null, created_date datetime not null, deleted bit not null, last_modified_date datetime, origin nvarchar(255) not null, sort_order integer, version bigint not null, attribute_type nvarchar(255) not null, created_by_id bigint, last_modified_by_id bigint, primary key (id)) engine=InnoDB;
create table app_permission_l10n (id bigint not null, created_date datetime not null, language_code nvarchar(255) not null, last_modified_date datetime, type nvarchar(255) not null, value nvarchar(2000) not null, version bigint not null, created_by_id bigint, last_modified_by_id bigint, attribute nvarchar(255), primary key (id)) engine=InnoDB;
create table app_role (id nvarchar(255) not null, active bit not null, created_date datetime not null, deleted bit not null, last_modified_date datetime, origin nvarchar(255) not null, sort_order integer, version bigint not null, attribute_type nvarchar(255) not null, created_by_id bigint, last_modified_by_id bigint, primary key (id)) engine=InnoDB;
create table app_role_l10n (id bigint not null, created_date datetime not null, language_code nvarchar(255) not null, last_modified_date datetime, type nvarchar(255) not null, value nvarchar(2000) not null, version bigint not null, created_by_id bigint, last_modified_by_id bigint, attribute nvarchar(255), primary key (id)) engine=InnoDB;
create table app_role_permissions (role_id nvarchar(255) not null, permission_id nvarchar(255) not null, primary key (role_id, permission_id)) engine=InnoDB;
create table app_user (id bigint not null, created_date datetime not null, last_modified_date datetime, password nvarchar(255), username nvarchar(255) not null, version bigint not null, contact_id bigint, created_by_id bigint, last_modified_by_id bigint, primary key (id)) engine=InnoDB;
create table app_user_roles (user_id bigint not null, role_id nvarchar(255) not null, primary key (user_id, role_id)) engine=InnoDB;
create table app_language$localization_seq (next_val bigint) engine=InnoDB;
insert into app_language$localization_seq values ( 1 );
create table attribute_type (id nvarchar(255) not null, active bit not null, created_date datetime not null, deleted bit not null, last_modified_date datetime, version bigint not null, created_by_id bigint, last_modified_by_id bigint, primary key (id)) engine=InnoDB;
create table attribute_type_l10n (id bigint not null, created_date datetime not null, language_code nvarchar(255) not null, last_modified_date datetime, type nvarchar(255) not null, value nvarchar(2000) not null, version bigint not null, created_by_id bigint, last_modified_by_id bigint, attribute_type nvarchar(255), primary key (id)) engine=InnoDB;
create table attribute_type_setup (attribute_type nvarchar(255) not null, created_date datetime not null, deleteable bit not null, editable bit not null, extendable bit not null, hideable bit not null, last_modified_date datetime, sortable bit not null, version bigint not null, created_by_id bigint, last_modified_by_id bigint, primary key (attribute_type)) engine=InnoDB;
create table attribute_type$localization_seq (next_val bigint) engine=InnoDB;
insert into attribute_type$localization_seq values ( 1 );
create table contact (id bigint not null, created_date datetime not null, email nvarchar(255), firstname nvarchar(255), last_modified_date datetime, lastname nvarchar(255), version bigint not null, created_by_id bigint, gender nvarchar(255) not null, last_modified_by_id bigint, primary key (id)) engine=InnoDB;
create table contact_seq (next_val bigint) engine=InnoDB;
insert into contact_seq values ( 1 );
create table gender (id nvarchar(255) not null, active bit not null, created_date datetime not null, deleted bit not null, last_modified_date datetime, origin nvarchar(255) not null, sort_order integer, version bigint not null, attribute_type nvarchar(255) not null, created_by_id bigint, last_modified_by_id bigint, primary key (id)) engine=InnoDB;
create table gender$localization_seq (next_val bigint) engine=InnoDB;
insert into gender$localization_seq values ( 1 );
create table gender_l10n (id bigint not null, created_date datetime not null, language_code nvarchar(255) not null, last_modified_date datetime, type nvarchar(255) not null, value nvarchar(2000) not null, version bigint not null, created_by_id bigint, last_modified_by_id bigint, attribute nvarchar(255), primary key (id)) engine=InnoDB;
create table permission$localization_seq (next_val bigint) engine=InnoDB;
insert into permission$localization_seq values ( 1 );
create table role$localization_seq (next_val bigint) engine=InnoDB;
insert into role$localization_seq values ( 1 );
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
alter table app_user add constraint UK3k4cplvh82srueuttfkwnylq0 unique (username);
alter table app_language add constraint FKh0s9dhkbqebj5ylqroe5d2iix foreign key (attribute_type) references attribute_type (id);
alter table app_language add constraint FKj8ybyfqwdxd18pl7ie5sku275 foreign key (created_by_id) references app_user (id);
alter table app_language add constraint FKk4wlk885an7gbtpjljjjrfi3p foreign key (last_modified_by_id) references app_user (id);
alter table app_language_l10n add constraint FK7ajcd24gaqrvepcd8thqiursc foreign key (created_by_id) references app_user (id);
alter table app_language_l10n add constraint FKkevs1xxgnfs3xy2r0lp933ye5 foreign key (last_modified_by_id) references app_user (id);
alter table app_language_l10n add constraint FKbd8a1nv1fcxuquwvxsarm8q08 foreign key (attribute) references app_language (id);
alter table app_permission add constraint FKbt2v0roscpvg6e9pnj3aydsqr foreign key (attribute_type) references attribute_type (id);
alter table app_permission add constraint FK6q1l4xjxv1p40jeku1r43thkf foreign key (created_by_id) references app_user (id);
alter table app_permission add constraint FKp2opcwtp8j2253jw25flaqvai foreign key (last_modified_by_id) references app_user (id);
alter table app_permission_l10n add constraint FKg0ughyqpci790bqhdq2058wix foreign key (created_by_id) references app_user (id);
alter table app_permission_l10n add constraint FK6ydp4n4d1hvs13640frjacoox foreign key (last_modified_by_id) references app_user (id);
alter table app_permission_l10n add constraint FKkt6g7tb7xnh37c8aqhc3o5a67 foreign key (attribute) references app_permission (id);
alter table app_role add constraint FK94gccxdqxrncpe40caf7vwf8y foreign key (attribute_type) references attribute_type (id);
alter table app_role add constraint FKpjeyrdvlmq8x6fo0uhhvbau4x foreign key (created_by_id) references app_user (id);
alter table app_role add constraint FKg29868ulsfko0eenf4om576f7 foreign key (last_modified_by_id) references app_user (id);
alter table app_role_l10n add constraint FKmgvow11xhn2og2ktseixyppk6 foreign key (created_by_id) references app_user (id);
alter table app_role_l10n add constraint FKmt99b8uxbwlweq11xo73sjuyu foreign key (last_modified_by_id) references app_user (id);
alter table app_role_l10n add constraint FKe6yxvepjurmholt30ax2t3090 foreign key (attribute) references app_role (id);
alter table app_role_permissions add constraint FKhj9btn1giylub8xpf22y1s1yj foreign key (permission_id) references app_permission (id);
alter table app_role_permissions add constraint FK5ejh9hrq3wlrgqvxxv9eq0g8g foreign key (role_id) references app_role (id);
alter table app_user add constraint FKlkv4hvh7geqc0f4iessohwnwd foreign key (contact_id) references contact (id);
alter table app_user add constraint FKlqd19spd436qxo0ic3v7klhwh foreign key (created_by_id) references app_user (id);
alter table app_user add constraint FKee6nreu2puabqwda2a9d0vp8y foreign key (last_modified_by_id) references app_user (id);
alter table app_user_roles add constraint FKoakt07mc9x8g42934jlh183n7 foreign key (role_id) references app_role (id);
alter table app_user_roles add constraint FK3lwiahkol5aetc57pto5olacf foreign key (user_id) references app_user (id);
alter table attribute_type add constraint FKudsr0sn6o848eesypx64xqd1 foreign key (created_by_id) references app_user (id);
alter table attribute_type add constraint FKnyttgeh9fk2tmh714c23i2kai foreign key (last_modified_by_id) references app_user (id);
alter table attribute_type_l10n add constraint FK7y78uuuuf9cl7pc9notolq994 foreign key (created_by_id) references app_user (id);
alter table attribute_type_l10n add constraint FK3s14qkv6xk34bcw1p8avy2g93 foreign key (last_modified_by_id) references app_user (id);
alter table attribute_type_l10n add constraint FKsm0m4k19huin7bbx1vb965x5t foreign key (attribute_type) references attribute_type (id);
alter table attribute_type_setup add constraint FKca0qk5gkhf80vgfiejvr4l1se foreign key (created_by_id) references app_user (id);
alter table attribute_type_setup add constraint FKd8u0aqy74f5wlmm3eiqapl4xc foreign key (last_modified_by_id) references app_user (id);
alter table contact add constraint FK14cmp9be36agr8bk0yr1cyf4h foreign key (created_by_id) references app_user (id);
alter table contact add constraint FKdoetcflog2qbwm0m10fj5ncxa foreign key (gender) references gender (id);
alter table contact add constraint FK13pbh9fyrlx893xitm053qmrr foreign key (last_modified_by_id) references app_user (id);
alter table gender add constraint FK8pki0sk3ife2hmfq8159nr2m1 foreign key (attribute_type) references attribute_type (id);
alter table gender add constraint FKmil9olifwoneara4dqd8775k7 foreign key (created_by_id) references app_user (id);
alter table gender add constraint FKe5j90esps2ywt9x24p2h00wqw foreign key (last_modified_by_id) references app_user (id);
alter table gender_l10n add constraint FKc1urc6udo3bphugdxjhelbog7 foreign key (created_by_id) references app_user (id);
alter table gender_l10n add constraint FKqsiyigt94vu0lt9c3gr798h14 foreign key (last_modified_by_id) references app_user (id);
alter table gender_l10n add constraint FKn6tws0y5sp4ubh4fuv7glvki7 foreign key (attribute) references gender (id);

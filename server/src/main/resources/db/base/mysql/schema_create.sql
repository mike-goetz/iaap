create table app_language
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint        not null,
    country             nvarchar(2)   not null,
    language            nvarchar(2)   not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_language_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_permission
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint        not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_permission_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_role
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint        not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_role_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_role_permissions
(
    role_id       nvarchar(255) not null,
    permission_id nvarchar(255) not null,
    primary key (role_id, permission_id)
) engine = InnoDB;
create table app_user
(
    id                  bigint        not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    password            nvarchar(255),
    username            nvarchar(255) not null,
    version             bigint        not null,
    contact_id          bigint,
    created_by_id       bigint,
    last_modified_by_id bigint,
    primary key (id)
) engine = InnoDB;
create table app_user_roles
(
    user_id bigint        not null,
    role_id nvarchar(255) not null,
    primary key (user_id, role_id)
) engine = InnoDB;
create table app_language_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into app_language_l10n_seq
values (1);
create table attribute_status
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint        not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_status_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_status_transition
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    version             bigint        not null,
    active              bit           not null,
    deleted             bit           not null,
    origin              nvarchar(255) not null,
    sort_order          integer,
    target              nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_status_transition_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    transition          nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_type
(
    id                  nvarchar(255) not null,
    active              bit           not null,
    created_date        datetime      not null,
    deleted             bit           not null,
    last_modified_date  datetime,
    version             bigint        not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    primary key (id)
) engine = InnoDB;
create table attribute_type_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute_type      nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_type_setup
(
    attribute_type      nvarchar(255) not null,
    created_date        datetime      not null,
    deleteable          bit           not null,
    editable            bit           not null,
    extendable          bit           not null,
    hideable            bit           not null,
    last_modified_date  datetime,
    sortable            bit           not null,
    version             bigint        not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    primary key (attribute_type)
) engine = InnoDB;
create table attribute_status_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into attribute_status_l10n_seq
values (1);
create table attribute_status_transition_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into attribute_status_transition_l10n_seq
values (1);
create table attribute_type_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into attribute_type_l10n_seq
values (1);
create table contact
(
    id                  bigint        not null,
    created_date        datetime      not null,
    email               nvarchar(255),
    firstname           nvarchar(255),
    last_modified_date  datetime,
    lastname            nvarchar(255),
    version             bigint        not null,
    created_by_id       bigint,
    gender              nvarchar(255) not null,
    last_modified_by_id bigint,
    primary key (id)
) engine = InnoDB;
create table contact_seq
(
    next_val bigint
) engine = InnoDB;
insert into contact_seq
values (1);
create table gender
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint        not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table gender_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into gender_l10n_seq
values (1);
create table gender_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table permission_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into permission_l10n_seq
values (1);
create table race_event
(
    id                  bigint        not null,
    created_date        datetime      not null,
    description         nvarchar(255),
    end                 datetime,
    last_modified_date  datetime,
    name                nvarchar(255),
    start               datetime,
    version             bigint        not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status_id           nvarchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table race_event_status
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint        not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table race_event_status_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table race_event_status_transition
(
    id                  nvarchar(255) not null,
    created_date        datetime      not null,
    last_modified_date  datetime,
    version             bigint        not null,
    active              bit           not null,
    deleted             bit           not null,
    origin              nvarchar(255) not null,
    sort_order          integer,
    target              nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table race_event_status_transition_l10n
(
    id                  bigint         not null,
    created_date        datetime       not null,
    language_code       nvarchar(255)  not null,
    last_modified_date  datetime,
    type                nvarchar(255)  not null,
    value               nvarchar(2000) not null,
    version             bigint         not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    transition          nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table race_event_status_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into race_event_status_l10n_seq
values (1);
create table race_event_status_transition_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into race_event_status_transition_l10n_seq
values (1);
create table race_event_seq
(
    next_val bigint
) engine = InnoDB;
insert into race_event_seq
values (1);
create table role_l10n_seq
(
    next_val bigint
) engine = InnoDB;
insert into role_l10n_seq
values (1);
create table user_seq
(
    next_val bigint
) engine = InnoDB;
insert into user_seq
values (1);
alter table app_user
    add constraint UK3k4cplvh82srueuttfkwnylq0 unique (username);
alter table app_language
    add constraint FKh0s9dhkbqebj5ylqroe5d2iix foreign key (attribute_type) references attribute_type (id);
alter table app_language
    add constraint FKj8ybyfqwdxd18pl7ie5sku275 foreign key (created_by_id) references app_user (id);
alter table app_language
    add constraint FKk4wlk885an7gbtpjljjjrfi3p foreign key (last_modified_by_id) references app_user (id);
alter table app_language
    add constraint FKcrfolfp61bj6wlo8y6wtojep4 foreign key (status) references attribute_status (id);
alter table app_language_l10n
    add constraint FK7ajcd24gaqrvepcd8thqiursc foreign key (created_by_id) references app_user (id);
alter table app_language_l10n
    add constraint FKkevs1xxgnfs3xy2r0lp933ye5 foreign key (last_modified_by_id) references app_user (id);
alter table app_language_l10n
    add constraint FKbd8a1nv1fcxuquwvxsarm8q08 foreign key (attribute) references app_language (id);
alter table app_permission
    add constraint FKbt2v0roscpvg6e9pnj3aydsqr foreign key (attribute_type) references attribute_type (id);
alter table app_permission
    add constraint FK6q1l4xjxv1p40jeku1r43thkf foreign key (created_by_id) references app_user (id);
alter table app_permission
    add constraint FKp2opcwtp8j2253jw25flaqvai foreign key (last_modified_by_id) references app_user (id);
alter table app_permission
    add constraint FK6mnlatrpcobombmm2ooqqwhom foreign key (status) references attribute_status (id);
alter table app_permission_l10n
    add constraint FKg0ughyqpci790bqhdq2058wix foreign key (created_by_id) references app_user (id);
alter table app_permission_l10n
    add constraint FK6ydp4n4d1hvs13640frjacoox foreign key (last_modified_by_id) references app_user (id);
alter table app_permission_l10n
    add constraint FKkt6g7tb7xnh37c8aqhc3o5a67 foreign key (attribute) references app_permission (id);
alter table app_role
    add constraint FK94gccxdqxrncpe40caf7vwf8y foreign key (attribute_type) references attribute_type (id);
alter table app_role
    add constraint FKpjeyrdvlmq8x6fo0uhhvbau4x foreign key (created_by_id) references app_user (id);
alter table app_role
    add constraint FKg29868ulsfko0eenf4om576f7 foreign key (last_modified_by_id) references app_user (id);
alter table app_role
    add constraint FKgh1wvr23wmqlb4qs609qcq1xn foreign key (status) references attribute_status (id);
alter table app_role_l10n
    add constraint FKmgvow11xhn2og2ktseixyppk6 foreign key (created_by_id) references app_user (id);
alter table app_role_l10n
    add constraint FKmt99b8uxbwlweq11xo73sjuyu foreign key (last_modified_by_id) references app_user (id);
alter table app_role_l10n
    add constraint FKe6yxvepjurmholt30ax2t3090 foreign key (attribute) references app_role (id);
alter table app_role_permissions
    add constraint FKhj9btn1giylub8xpf22y1s1yj foreign key (permission_id) references app_permission (id);
alter table app_role_permissions
    add constraint FK5ejh9hrq3wlrgqvxxv9eq0g8g foreign key (role_id) references app_role (id);
alter table app_user
    add constraint FKlkv4hvh7geqc0f4iessohwnwd foreign key (contact_id) references contact (id);
alter table app_user
    add constraint FKlqd19spd436qxo0ic3v7klhwh foreign key (created_by_id) references app_user (id);
alter table app_user
    add constraint FKee6nreu2puabqwda2a9d0vp8y foreign key (last_modified_by_id) references app_user (id);
alter table app_user_roles
    add constraint FKoakt07mc9x8g42934jlh183n7 foreign key (role_id) references app_role (id);
alter table app_user_roles
    add constraint FK3lwiahkol5aetc57pto5olacf foreign key (user_id) references app_user (id);
alter table attribute_status
    add constraint FKno6ohoqdoq779y2k98s0yli1 foreign key (attribute_type) references attribute_type (id);
alter table attribute_status
    add constraint FKbc05jo4suq09m47n28s5nq4gi foreign key (created_by_id) references app_user (id);
alter table attribute_status
    add constraint FKl5g2o3q6ypr1c91r3fmiq517o foreign key (last_modified_by_id) references app_user (id);
alter table attribute_status
    add constraint FK4eq7v7t400vvdoy6re1imnhm9 foreign key (status) references attribute_status (id);
alter table attribute_status_l10n
    add constraint FKtm4h8fclvd5rvgb2qc4nfvm82 foreign key (created_by_id) references app_user (id);
alter table attribute_status_l10n
    add constraint FKlxpxobkusen977lvydfa6tsdx foreign key (last_modified_by_id) references app_user (id);
alter table attribute_status_l10n
    add constraint FKomhrl3jj20516t2yj7hb78da foreign key (attribute) references attribute_status (id);
alter table attribute_status_transition
    add constraint FK2sdcp4scue5w7oimkakknyulr foreign key (created_by_id) references app_user (id);
alter table attribute_status_transition
    add constraint FKg0xkhqfsfcnd18b5byxawp7t1 foreign key (last_modified_by_id) references app_user (id);
alter table attribute_status_transition
    add constraint FKlphp1obx8mhiv42iyn91qt6e1 foreign key (status) references attribute_status (id);
alter table attribute_status_transition_l10n
    add constraint FKlaiyepqgc7wfm3jx5i2mb4cgp foreign key (created_by_id) references app_user (id);
alter table attribute_status_transition_l10n
    add constraint FKqiaad40hmcq6328t2alj2j4ww foreign key (last_modified_by_id) references app_user (id);
alter table attribute_status_transition_l10n
    add constraint FKa9ajtfmanp81iksfdv7aooq0f foreign key (transition) references attribute_status_transition (id);
alter table attribute_type
    add constraint FKudsr0sn6o848eesypx64xqd1 foreign key (created_by_id) references app_user (id);
alter table attribute_type
    add constraint FKnyttgeh9fk2tmh714c23i2kai foreign key (last_modified_by_id) references app_user (id);
alter table attribute_type_l10n
    add constraint FK7y78uuuuf9cl7pc9notolq994 foreign key (created_by_id) references app_user (id);
alter table attribute_type_l10n
    add constraint FK3s14qkv6xk34bcw1p8avy2g93 foreign key (last_modified_by_id) references app_user (id);
alter table attribute_type_l10n
    add constraint FKsm0m4k19huin7bbx1vb965x5t foreign key (attribute_type) references attribute_type (id);
alter table attribute_type_setup
    add constraint FKca0qk5gkhf80vgfiejvr4l1se foreign key (created_by_id) references app_user (id);
alter table attribute_type_setup
    add constraint FKd8u0aqy74f5wlmm3eiqapl4xc foreign key (last_modified_by_id) references app_user (id);
alter table contact
    add constraint FK14cmp9be36agr8bk0yr1cyf4h foreign key (created_by_id) references app_user (id);
alter table contact
    add constraint FKdoetcflog2qbwm0m10fj5ncxa foreign key (gender) references gender (id);
alter table contact
    add constraint FK13pbh9fyrlx893xitm053qmrr foreign key (last_modified_by_id) references app_user (id);
alter table gender
    add constraint FK8pki0sk3ife2hmfq8159nr2m1 foreign key (attribute_type) references attribute_type (id);
alter table gender
    add constraint FKmil9olifwoneara4dqd8775k7 foreign key (created_by_id) references app_user (id);
alter table gender
    add constraint FKe5j90esps2ywt9x24p2h00wqw foreign key (last_modified_by_id) references app_user (id);
alter table gender
    add constraint FK6xnrvfr7fjow3ggwbjw42a7sm foreign key (status) references attribute_status (id);
alter table gender_l10n
    add constraint FKc1urc6udo3bphugdxjhelbog7 foreign key (created_by_id) references app_user (id);
alter table gender_l10n
    add constraint FKqsiyigt94vu0lt9c3gr798h14 foreign key (last_modified_by_id) references app_user (id);
alter table gender_l10n
    add constraint FKn6tws0y5sp4ubh4fuv7glvki7 foreign key (attribute) references gender (id);
alter table race_event
    add constraint FKov3x4r2cgt8nqnlsgsquongco foreign key (created_by_id) references app_user (id);
alter table race_event
    add constraint FKsubsgjy4pk2ap566a4my19ox1 foreign key (last_modified_by_id) references app_user (id);
alter table race_event
    add constraint FKnmc62hlldddmjcw42pc28qn4o foreign key (status_id) references race_event_status (id);
alter table race_event_status
    add constraint FKb5evvqd2iqh9y292vthqd4brr foreign key (attribute_type) references attribute_type (id);
alter table race_event_status
    add constraint FKsx941sfgq2wi1lvehstnfdht8 foreign key (created_by_id) references app_user (id);
alter table race_event_status
    add constraint FK9hpmd8inf4dgbf4yx422h1mwu foreign key (last_modified_by_id) references app_user (id);
alter table race_event_status
    add constraint FKk4y89afdsypb3vjb7lshdmxdg foreign key (status) references attribute_status (id);
alter table race_event_status_l10n
    add constraint FK99ulw7tl5b4aof9htkjgn2j10 foreign key (created_by_id) references app_user (id);
alter table race_event_status_l10n
    add constraint FKe7hgnsg9act5feo3x74vjgra4 foreign key (last_modified_by_id) references app_user (id);
alter table race_event_status_l10n
    add constraint FK4ahlers6yqpxjqbkudm23h6hh foreign key (attribute) references race_event_status (id);
alter table race_event_status_transition
    add constraint FK9682qqgov2iily16uo5cbhlo2 foreign key (created_by_id) references app_user (id);
alter table race_event_status_transition
    add constraint FKm21c6y6f9vqnf4ltjpg8k55dd foreign key (last_modified_by_id) references app_user (id);
alter table race_event_status_transition
    add constraint FKdrpkgw0l8la73ex5l2nsb55bm foreign key (status) references race_event_status (id);
alter table race_event_status_transition_l10n
    add constraint FK5do7l0ncd70him6a8gpcbj0mg foreign key (created_by_id) references app_user (id);
alter table race_event_status_transition_l10n
    add constraint FKhxggber7u4fbq32ix871r1i61 foreign key (last_modified_by_id) references app_user (id);
alter table race_event_status_transition_l10n
    add constraint FK2ha2oypw3aa146nkgsyyw0d2f foreign key (transition) references race_event_status_transition (id);

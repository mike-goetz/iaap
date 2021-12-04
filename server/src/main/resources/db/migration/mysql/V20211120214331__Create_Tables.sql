create table app_language
(
    id                  nvarchar(255) not null,
    created_date        datetime not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint   not null,
    country             nvarchar(2) not null,
    language            nvarchar(2) not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_language_l10n
(
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_permission
(
    id                  nvarchar(255) not null,
    created_date        datetime not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint   not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_permission_l10n
(
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_role
(
    id                  nvarchar(255) not null,
    created_date        datetime not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint   not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table app_role_l10n
(
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
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
    id                  bigint   not null,
    created_date        datetime not null,
    last_modified_date  datetime,
    password            nvarchar(255),
    username            nvarchar(255) not null,
    version             bigint   not null,
    contact_id          bigint,
    created_by_id       bigint,
    last_modified_by_id bigint,
    primary key (id)
) engine = InnoDB;
create table app_user_roles
(
    user_id bigint not null,
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
    created_date        datetime not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint   not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_status_l10n
(
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_status_transition
(
    id                  nvarchar(255) not null,
    created_date        datetime not null,
    last_modified_date  datetime,
    version             bigint   not null,
    active              bit      not null,
    deleted             bit      not null,
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
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    transition          nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_type
(
    id                  nvarchar(255) not null,
    active              bit      not null,
    created_date        datetime not null,
    deleted             bit      not null,
    last_modified_date  datetime,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    primary key (id)
) engine = InnoDB;
create table attribute_type_l10n
(
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute_type      nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table attribute_type_setup
(
    attribute_type      nvarchar(255) not null,
    created_date        datetime not null,
    deleteable          bit      not null,
    editable            bit      not null,
    extendable          bit      not null,
    hideable            bit      not null,
    last_modified_date  datetime,
    sortable            bit      not null,
    version             bigint   not null,
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
    id                  bigint   not null,
    created_date        datetime not null,
    email               nvarchar(255),
    firstname           nvarchar(255),
    last_modified_date  datetime,
    lastname            nvarchar(255),
    version             bigint   not null,
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
    created_date        datetime not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint   not null,
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
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
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
    id                  bigint   not null,
    created_date        datetime not null,
    description         nvarchar(255),
    end                 datetime,
    last_modified_date  datetime,
    name                nvarchar(255),
    start               datetime,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status_id           nvarchar(255) not null,
    primary key (id)
) engine = InnoDB;
create table race_event_status
(
    id                  nvarchar(255) not null,
    created_date        datetime not null,
    last_modified_date  datetime,
    origin              nvarchar(255) not null,
    sort_order          integer,
    version             bigint   not null,
    attribute_type      nvarchar(255) not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    status              nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table race_event_status_l10n
(
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
    created_by_id       bigint,
    last_modified_by_id bigint,
    attribute           nvarchar(255),
    primary key (id)
) engine = InnoDB;
create table race_event_status_transition
(
    id                  nvarchar(255) not null,
    created_date        datetime not null,
    last_modified_date  datetime,
    version             bigint   not null,
    active              bit      not null,
    deleted             bit      not null,
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
    id                  bigint   not null,
    created_date        datetime not null,
    language_code       nvarchar(255) not null,
    last_modified_date  datetime,
    type                nvarchar(255) not null,
    value               nvarchar(2000) not null,
    version             bigint   not null,
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

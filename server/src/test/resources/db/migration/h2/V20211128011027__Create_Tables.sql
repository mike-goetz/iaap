create
    sequence app_language_l10n_seq start
    with 1 increment by 1;
create
    sequence attribute_status_l10n_seq start
    with 1 increment by 1;
create
    sequence attribute_status_transition_l10n_seq start
    with 1 increment by 1;
create
    sequence attribute_type_l10n_seq start
    with 1 increment by 1;
create
    sequence contact_seq start
    with 1 increment by 1;
create
    sequence gender_l10n_seq start
    with 1 increment by 1;
create
    sequence permission_l10n_seq start
    with 1 increment by 1;
create
    sequence race_event_status_l10n_seq start
    with 1 increment by 1;
create
    sequence race_event_status_transition_l10n_seq start
    with 1 increment by 1;
create
    sequence race_event_seq start
    with 1 increment by 1;
create
    sequence role_l10n_seq start
    with 1 increment by 1;
create
    sequence user_seq start
    with 1 increment by 1;
create table app_language
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    version             number (19,0) not null,
    country             nvarchar2(2) not null,
    language            nvarchar2(2) not null,
    attribute_type      nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table app_language_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    attribute           nvarchar2(255),
    primary key (id)
);
create table app_permission
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    version             number (19,0) not null,
    attribute_type      nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table app_permission_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    attribute           nvarchar2(255),
    primary key (id)
);
create table app_role
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    version             number (19,0) not null,
    attribute_type      nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table app_role_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    attribute           nvarchar2(255),
    primary key (id)
);
create table app_role_permissions
(
    role_id       nvarchar2(255) not null,
    permission_id nvarchar2(255) not null,
    primary key (role_id, permission_id)
);
create table app_user
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    password            nvarchar2(255),
    username            nvarchar2(255) not null,
    version             number (19,0) not null,
    contact_id          number (19,0),
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    primary key (id)
);
create table app_user_roles
(
    user_id number (19,0) not null,
    role_id nvarchar2(255) not null,
    primary key (user_id, role_id)
);
create table attribute_status
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    version             number (19,0) not null,
    attribute_type      nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table attribute_status_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    attribute           nvarchar2(255),
    primary key (id)
);
create table attribute_status_transition
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    version             number (19,0) not null,
    active              number (1,0) not null,
    deleted             number (1,0) not null,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    target              nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table attribute_status_transition_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    transition          nvarchar2(255),
    primary key (id)
);
create table attribute_type
(
    id                  nvarchar2(255) not null,
    active              number (1,0) not null,
    created_date        timestamp not null,
    deleted             number (1,0) not null,
    last_modified_date  timestamp,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    primary key (id)
);
create table attribute_type_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    attribute_type      nvarchar2(255),
    primary key (id)
);
create table attribute_type_setup
(
    attribute_type      nvarchar2(255) not null,
    created_date        timestamp not null,
    deleteable          number (1,0) not null,
    editable            number (1,0) not null,
    extendable          number (1,0) not null,
    hideable            number (1,0) not null,
    last_modified_date  timestamp,
    sortable            number (1,0) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    primary key (attribute_type)
);
create table contact
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    email               nvarchar2(255),
    firstname           nvarchar2(255),
    last_modified_date  timestamp,
    lastname            nvarchar2(255),
    version             number (19,0) not null,
    created_by_id       number (19,0),
    gender              nvarchar2(255) not null,
    last_modified_by_id number (19,0),
    primary key (id)
);
create table gender
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    version             number (19,0) not null,
    attribute_type      nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table gender_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    attribute           nvarchar2(255),
    primary key (id)
);
create table race_event
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    description         nvarchar2(255),
    end                 timestamp,
    last_modified_date  timestamp,
    name                nvarchar2(255),
    start               timestamp,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status_id           nvarchar2(255) not null,
    primary key (id)
);
create table race_event_status
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    version             number (19,0) not null,
    attribute_type      nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table race_event_status_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    attribute           nvarchar2(255),
    primary key (id)
);
create table race_event_status_transition
(
    id                  nvarchar2(255) not null,
    created_date        timestamp not null,
    last_modified_date  timestamp,
    version             number (19,0) not null,
    active              number (1,0) not null,
    deleted             number (1,0) not null,
    origin              nvarchar2(255) not null,
    sort_order          number (10,0),
    target              nvarchar2(255) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    status              nvarchar2(255),
    primary key (id)
);
create table race_event_status_transition_l10n
(
    id                  number (19,0) not null,
    created_date        timestamp not null,
    language_code       nvarchar2(255) not null,
    last_modified_date  timestamp,
    type                nvarchar2(255) not null,
    value               nvarchar2(2000) not null,
    version             number (19,0) not null,
    created_by_id       number (19,0),
    last_modified_by_id number (19,0),
    transition          nvarchar2(255),
    primary key (id)
);

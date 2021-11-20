alter table app_language drop foreign key FKh0s9dhkbqebj5ylqroe5d2iix;
alter table app_language drop foreign key FKj8ybyfqwdxd18pl7ie5sku275;
alter table app_language drop foreign key FKk4wlk885an7gbtpjljjjrfi3p;
alter table app_language_l10n drop foreign key FK7ajcd24gaqrvepcd8thqiursc;
alter table app_language_l10n drop foreign key FKkevs1xxgnfs3xy2r0lp933ye5;
alter table app_language_l10n drop foreign key FKbd8a1nv1fcxuquwvxsarm8q08;
alter table app_permission drop foreign key FKbt2v0roscpvg6e9pnj3aydsqr;
alter table app_permission drop foreign key FK6q1l4xjxv1p40jeku1r43thkf;
alter table app_permission drop foreign key FKp2opcwtp8j2253jw25flaqvai;
alter table app_permission_l10n drop foreign key FKg0ughyqpci790bqhdq2058wix;
alter table app_permission_l10n drop foreign key FK6ydp4n4d1hvs13640frjacoox;
alter table app_permission_l10n drop foreign key FKkt6g7tb7xnh37c8aqhc3o5a67;
alter table app_role drop foreign key FK94gccxdqxrncpe40caf7vwf8y;
alter table app_role drop foreign key FKpjeyrdvlmq8x6fo0uhhvbau4x;
alter table app_role drop foreign key FKg29868ulsfko0eenf4om576f7;
alter table app_role_l10n drop foreign key FKmgvow11xhn2og2ktseixyppk6;
alter table app_role_l10n drop foreign key FKmt99b8uxbwlweq11xo73sjuyu;
alter table app_role_l10n drop foreign key FKe6yxvepjurmholt30ax2t3090;
alter table app_role_permissions drop foreign key FKhj9btn1giylub8xpf22y1s1yj;
alter table app_role_permissions drop foreign key FK5ejh9hrq3wlrgqvxxv9eq0g8g;
alter table app_user drop foreign key FKlkv4hvh7geqc0f4iessohwnwd;
alter table app_user drop foreign key FKlqd19spd436qxo0ic3v7klhwh;
alter table app_user drop foreign key FKee6nreu2puabqwda2a9d0vp8y;
alter table app_user_roles drop foreign key FKoakt07mc9x8g42934jlh183n7;
alter table app_user_roles drop foreign key FK3lwiahkol5aetc57pto5olacf;
alter table attribute_type drop foreign key FKudsr0sn6o848eesypx64xqd1;
alter table attribute_type drop foreign key FKnyttgeh9fk2tmh714c23i2kai;
alter table attribute_type_l10n drop foreign key FK7y78uuuuf9cl7pc9notolq994;
alter table attribute_type_l10n drop foreign key FK3s14qkv6xk34bcw1p8avy2g93;
alter table attribute_type_l10n drop foreign key FKsm0m4k19huin7bbx1vb965x5t;
alter table attribute_type_setup drop foreign key FKca0qk5gkhf80vgfiejvr4l1se;
alter table attribute_type_setup drop foreign key FKd8u0aqy74f5wlmm3eiqapl4xc;
alter table contact drop foreign key FK14cmp9be36agr8bk0yr1cyf4h;
alter table contact drop foreign key FKdoetcflog2qbwm0m10fj5ncxa;
alter table contact drop foreign key FK13pbh9fyrlx893xitm053qmrr;
alter table gender drop foreign key FK8pki0sk3ife2hmfq8159nr2m1;
alter table gender drop foreign key FKmil9olifwoneara4dqd8775k7;
alter table gender drop foreign key FKe5j90esps2ywt9x24p2h00wqw;
alter table gender_l10n drop foreign key FKc1urc6udo3bphugdxjhelbog7;
alter table gender_l10n drop foreign key FKqsiyigt94vu0lt9c3gr798h14;
alter table gender_l10n drop foreign key FKn6tws0y5sp4ubh4fuv7glvki7;
drop table if exists app_language;
drop table if exists app_language_l10n;
drop table if exists app_permission;
drop table if exists app_permission_l10n;
drop table if exists app_role;
drop table if exists app_role_l10n;
drop table if exists app_role_permissions;
drop table if exists app_user;
drop table if exists app_user_roles;
drop table if exists app_language$localization_seq;
drop table if exists attribute_type;
drop table if exists attribute_type_l10n;
drop table if exists attribute_type_setup;
drop table if exists attribute_type$localization_seq;
drop table if exists contact;
drop table if exists contact_seq;
drop table if exists gender;
drop table if exists gender$localization_seq;
drop table if exists gender_l10n;
drop table if exists permission$localization_seq;
drop table if exists role$localization_seq;
drop table if exists user_seq;
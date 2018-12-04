create index IX_259C49C on Marist_Server (cpu[$COLUMN_LENGTH:75$]);
create index IX_9E3C5534 on Marist_Server (distribution[$COLUMN_LENGTH:75$]);
create index IX_E9B171B0 on Marist_Server (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CB4AA432 on Marist_Server (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_36568E8 on Marist_Server (vpn);
create table Marist_Server (
	uuid_ VARCHAR(75) null,
	serverId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	distribution VARCHAR(75) null,
	version VARCHAR(75) null,
	vpn BOOLEAN,
	memory INTEGER,
	disk INTEGER,
	cpu VARCHAR(75) null
);
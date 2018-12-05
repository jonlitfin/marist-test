/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package marist.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import marist.service.model.Server;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Server in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Server
 * @generated
 */
@ProviderType
public class ServerCacheModel implements CacheModel<Server>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServerCacheModel)) {
			return false;
		}

		ServerCacheModel serverCacheModel = (ServerCacheModel)obj;

		if (serverId == serverCacheModel.serverId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serverId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", serverId=");
		sb.append(serverId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", distribution=");
		sb.append(distribution);
		sb.append(", version=");
		sb.append(version);
		sb.append(", vpn=");
		sb.append(vpn);
		sb.append(", memory=");
		sb.append(memory);
		sb.append(", disk=");
		sb.append(disk);
		sb.append(", cpu=");
		sb.append(cpu);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Server toEntityModel() {
		ServerImpl serverImpl = new ServerImpl();

		if (uuid == null) {
			serverImpl.setUuid("");
		}
		else {
			serverImpl.setUuid(uuid);
		}

		serverImpl.setServerId(serverId);
		serverImpl.setGroupId(groupId);
		serverImpl.setCompanyId(companyId);
		serverImpl.setUserId(userId);

		if (userName == null) {
			serverImpl.setUserName("");
		}
		else {
			serverImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			serverImpl.setCreateDate(null);
		}
		else {
			serverImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serverImpl.setModifiedDate(null);
		}
		else {
			serverImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			serverImpl.setName("");
		}
		else {
			serverImpl.setName(name);
		}

		if (distribution == null) {
			serverImpl.setDistribution("");
		}
		else {
			serverImpl.setDistribution(distribution);
		}

		if (version == null) {
			serverImpl.setVersion("");
		}
		else {
			serverImpl.setVersion(version);
		}

		serverImpl.setVpn(vpn);
		serverImpl.setMemory(memory);
		serverImpl.setDisk(disk);

		if (cpu == null) {
			serverImpl.setCpu("");
		}
		else {
			serverImpl.setCpu(cpu);
		}

		serverImpl.resetOriginalValues();

		return serverImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		serverId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		distribution = objectInput.readUTF();
		version = objectInput.readUTF();

		vpn = objectInput.readBoolean();

		memory = objectInput.readInt();

		disk = objectInput.readInt();
		cpu = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(serverId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (distribution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(distribution);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeBoolean(vpn);

		objectOutput.writeInt(memory);

		objectOutput.writeInt(disk);

		if (cpu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cpu);
		}
	}

	public String uuid;
	public long serverId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String distribution;
	public String version;
	public boolean vpn;
	public int memory;
	public int disk;
	public String cpu;
}
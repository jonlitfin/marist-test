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

package marist.service.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link marist.service.service.http.ServerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see marist.service.service.http.ServerServiceSoap
 * @generated
 */
@ProviderType
public class ServerSoap implements Serializable {
	public static ServerSoap toSoapModel(Server model) {
		ServerSoap soapModel = new ServerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setServerId(model.getServerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDistribution(model.getDistribution());
		soapModel.setVersion(model.getVersion());
		soapModel.setVpn(model.isVpn());
		soapModel.setMemory(model.getMemory());
		soapModel.setDisk(model.getDisk());
		soapModel.setCpu(model.getCpu());

		return soapModel;
	}

	public static ServerSoap[] toSoapModels(Server[] models) {
		ServerSoap[] soapModels = new ServerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServerSoap[][] toSoapModels(Server[][] models) {
		ServerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServerSoap[] toSoapModels(List<Server> models) {
		List<ServerSoap> soapModels = new ArrayList<ServerSoap>(models.size());

		for (Server model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServerSoap[soapModels.size()]);
	}

	public ServerSoap() {
	}

	public long getPrimaryKey() {
		return _serverId;
	}

	public void setPrimaryKey(long pk) {
		setServerId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getServerId() {
		return _serverId;
	}

	public void setServerId(long serverId) {
		_serverId = serverId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getDistribution() {
		return _distribution;
	}

	public void setDistribution(String distribution) {
		_distribution = distribution;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public boolean getVpn() {
		return _vpn;
	}

	public boolean isVpn() {
		return _vpn;
	}

	public void setVpn(boolean vpn) {
		_vpn = vpn;
	}

	public int getMemory() {
		return _memory;
	}

	public void setMemory(int memory) {
		_memory = memory;
	}

	public int getDisk() {
		return _disk;
	}

	public void setDisk(int disk) {
		_disk = disk;
	}

	public String getCpu() {
		return _cpu;
	}

	public void setCpu(String cpu) {
		_cpu = cpu;
	}

	private String _uuid;
	private long _serverId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _distribution;
	private String _version;
	private boolean _vpn;
	private int _memory;
	private int _disk;
	private String _cpu;
}
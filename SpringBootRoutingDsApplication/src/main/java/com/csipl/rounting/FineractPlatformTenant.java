package com.csipl.rounting;

public class FineractPlatformTenant {

	private final Long id;
	private final String tenantIdentifier;
	private final String name;
	private final String timezoneId;
	private final FineractPlatformTenantConnection connection;

	public FineractPlatformTenant(final Long id, final String tenantIdentifier, final String name,
			final String timezoneId, final FineractPlatformTenantConnection connection) {
		this.id = id;
		this.tenantIdentifier = tenantIdentifier;
		this.name = name;
		this.timezoneId = timezoneId;
		this.connection = connection;
	}

	public Long getId() {
		return this.id;
	}

	public String getTenantIdentifier() {
		return this.tenantIdentifier;
	}

	public String getName() {
		return this.name;
	}

	public String getTimezoneId() {
		return this.timezoneId;
	}

	public FineractPlatformTenantConnection getConnection() {
		return connection;
	}

}
package com.csipl.rounting;

import org.springframework.util.Assert;

/**
 *
 */
public class ThreadLocalContextUtil {

	public static final String CONTEXT_TENANTS = "tenants";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	private static final ThreadLocal<FineractPlatformTenant> tenantcontext = new ThreadLocal<>();

	private static final ThreadLocal<String> authTokenContext = new ThreadLocal<>();

	public static void setTenant(final FineractPlatformTenant tenant) {
		Assert.notNull(tenant, "tenant cannot be null");
		tenantcontext.set(tenant);
	}

	public static FineractPlatformTenant getTenant() {
		return tenantcontext.get();
	}

	public static void clearTenant() {
		tenantcontext.remove();
	}

	public static String getDataSourceContext() {
		return contextHolder.get();
	}

	public static void setDataSourceContext(final String dataSourceContext) {
		contextHolder.set(dataSourceContext);
	}

	public static void clearDataSourceContext() {
		contextHolder.remove();
	}

	public static void setAuthToken(final String authToken) {
		authTokenContext.set(authToken);
	}

	public static String getAuthToken() {
		return authTokenContext.get();
	}

}
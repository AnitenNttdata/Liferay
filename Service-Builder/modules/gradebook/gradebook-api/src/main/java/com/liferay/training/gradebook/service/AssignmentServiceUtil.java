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

package com.liferay.training.gradebook.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Assignment. This utility wraps
 * <code>com.liferay.training.gradebook.service.impl.AssignmentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentService
 * @generated
 */
public class AssignmentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.gradebook.service.impl.AssignmentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.training.gradebook.model.Assignment addAssignment(
			long groupId, String title, String description, Date dueDate,
			ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAssignment(
			groupId, title, description, dueDate, serviceContext);
	}

	public static com.liferay.training.gradebook.model.Assignment
			deleteAssignment(long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAssignment(assignmentId);
	}

	public static com.liferay.training.gradebook.model.Assignment getAssignment(
			long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAssignment(assignmentId);
	}

	public static List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByGroupId(long groupId) {

		return getService().getAssignmentsByGroupId(groupId);
	}

	public static List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByKeywords(
			long groupId, String keywords, int start, int end,
			OrderByComparator<com.liferay.training.gradebook.model.Assignment>
				orderByComparator) {

		return getService().getAssignmentsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static long getAssignmentsCountByKeywords(
		long groupId, String keywords) {

		return getService().getAssignmentsCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.training.gradebook.model.Assignment
			updateAssignment(
				long groupId, String title, String description, Date dueDate,
				ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateAssignment(
			groupId, title, description, dueDate, serviceContext);
	}

	public static AssignmentService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AssignmentService, AssignmentService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AssignmentService.class);

		ServiceTracker<AssignmentService, AssignmentService> serviceTracker =
			new ServiceTracker<AssignmentService, AssignmentService>(
				bundle.getBundleContext(), AssignmentService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
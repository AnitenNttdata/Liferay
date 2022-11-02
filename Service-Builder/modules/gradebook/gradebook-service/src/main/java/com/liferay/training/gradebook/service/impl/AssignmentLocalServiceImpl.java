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

package com.liferay.training.gradebook.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.training.gradebook.service.base.AssignmentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the assignment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.gradebook.service.AssignmentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.training.gradebook.model.Assignment",
	service = AopService.class
)
public class AssignmentLocalServiceImpl extends AssignmentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.training.gradebook.service.AssignmentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.training.gradebook.service.AssignmentLocalServiceUtil</code>.
	 */
	
	//Add Assignments

		public Assignment addAssignment(long groupId, String title, String description, Date dueDate,
				ServiceContext serviceContext) throws PortalException {
			// get group user
			Group group = groupLocalService.getGroup(groupId);
			long userId = serviceContext.getUserId();
			User user = userLocalService.getUser(userId);

			// Generate primary key for assignment
			long assignmentId = counterLocalService.increment(Assignment.class.getName());

			// Create assignment. This doesn´t yet persist the entity.
			Assignment assignment = createAssignment(assignmentId);

			// Populate fields
			assignment.setCompanyId(group.getCompanyId());
			assignment.setCreateDate(serviceContext.getCreateDate(new Date()));
			assignment.setDueDate(dueDate);
			assignment.setDescription(description);
			assignment.setGroupId(groupId);
			assignment.setModifiedDate(serviceContext.getModifiedDate(new Date()));
			assignment.setTitle(title);
			assignment.setUserId(userId);
			assignment.setUserName(user.getScreenName());

			// Persist assignment to database
			return super.addAssignment(assignment);
		}

		// Update Assignment method

		public Assignment updateAssignment(long groupId, String title,long assignmentId, String description, Date dueDate,
				ServiceContext serviceContext) throws PortalException {

			// Get assignment by id
			Assignment assignment = getAssignment(assignmentId);

			// Set updated fields and modification date
			assignment.setModifiedDate(new Date());
			assignment.setTitle(title);
			assignment.setDueDate(dueDate);
			assignment.setDescription(description);
			assignment = super.updateAssignment(assignment);
			return assignment;
		}

		// Finders Assignment

		// busqueda general all
		public List<Assignment> getAssignmentsByGroupId(long groupId) {
			return assignmentPersistence.findByGroupId(groupId);
		}

		// paginación
		public List<Assignment> getAssignmentsByGroupId(long groupId, int start, int end) {
			return assignmentPersistence.findByGroupId(groupId, start, end);
		}

		// busqueda ordenada
		public List<Assignment> getAssignmentsByGroupId(long groupId, int start, int end,
				OrderByComparator<Assignment> orderByComparator) {
			return assignmentPersistence.findByGroupId(groupId, start, end, orderByComparator);
		}

		// busqueda x teclado
		public List<Assignment> getAssignmentsByKeywords(long groupId, String keywords, int start, int end,
				OrderByComparator<Assignment> orderByComparator) {
			return assignmentLocalService.dynamicQuery(getKeywordsSearchDynamicQuery(groupId, keywords), start, end,
					orderByComparator);
		}

		// busqueda x teclado + cantidad de resultados
		public long getAssignmentsCountByKeywords(long groupId, String keywords) {
			return assignmentLocalService.dynamicQueryCount(getKeywordsSearchDynamicQuery(groupId, keywords));
		}

		private DynamicQuery getKeywordsSearchDynamicQuery(long groupId, String keywords) {
			DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
			if (Validator.isNotNull(keywords)) {
				Disjunction disjuctionQuery = RestrictionsFactoryUtil.disjunction();
				disjuctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
				disjuctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
				disjuctionQuery.add(disjuctionQuery);
			}
			return dynamicQuery;
		}

		@Override
			public Assignment addAssignment(Assignment assignment) {
				throw new UnsupportedOperationException("not supported.");
			}

		@Override
			public Assignment updateAssignment(Assignment assignment) {
				throw new UnsupportedOperationException("not supported.");
			}


}
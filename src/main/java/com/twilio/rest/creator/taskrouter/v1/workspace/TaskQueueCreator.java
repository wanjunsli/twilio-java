/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.creator.taskrouter.v1.workspace;

import com.twilio.rest.creator.Creator;
import com.twilio.rest.exception.ApiConnectionException;
import com.twilio.rest.exception.ApiException;
import com.twilio.rest.http.HttpMethod;
import com.twilio.rest.http.Request;
import com.twilio.rest.http.Response;
import com.twilio.rest.http.TwilioRestClient;
import com.twilio.rest.resource.RestException;
import com.twilio.rest.resource.taskrouter.v1.workspace.TaskQueue;

public class TaskQueueCreator extends Creator<TaskQueue> {
    private final String workspaceSid;
    private final String friendlyName;
    private final String reservationActivitySid;
    private final String assignmentActivitySid;
    private String targetWorkers;
    private Integer maxReservedWorkers;

    /**
     * Construct a new TaskQueueCreator.
     * 
     * @param workspaceSid The workspace_sid
     * @param friendlyName The friendly_name
     * @param reservationActivitySid The reservation_activity_sid
     * @param assignmentActivitySid The assignment_activity_sid
     */
    public TaskQueueCreator(final String workspaceSid, 
                            final String friendlyName, 
                            final String reservationActivitySid, 
                            final String assignmentActivitySid) {
        this.workspaceSid = workspaceSid;
        this.friendlyName = friendlyName;
        this.reservationActivitySid = reservationActivitySid;
        this.assignmentActivitySid = assignmentActivitySid;
    }

    /**
     * The target_workers.
     * 
     * @param targetWorkers The target_workers
     * @return this
     */
    public TaskQueueCreator setTargetWorkers(final String targetWorkers) {
        this.targetWorkers = targetWorkers;
        return this;
    }

    /**
     * The max_reserved_workers.
     * 
     * @param maxReservedWorkers The max_reserved_workers
     * @return this
     */
    public TaskQueueCreator setMaxReservedWorkers(final Integer maxReservedWorkers) {
        this.maxReservedWorkers = maxReservedWorkers;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created TaskQueue
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public TaskQueue execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.TASKROUTER,
            "/v1/Workspaces/" + this.workspaceSid + "/TaskQueues",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("TaskQueue creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return TaskQueue.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (reservationActivitySid != null) {
            request.addPostParam("ReservationActivitySid", reservationActivitySid);
        }
        
        if (assignmentActivitySid != null) {
            request.addPostParam("AssignmentActivitySid", assignmentActivitySid);
        }
        
        if (targetWorkers != null) {
            request.addPostParam("TargetWorkers", targetWorkers);
        }
        
        if (maxReservedWorkers != null) {
            request.addPostParam("MaxReservedWorkers", maxReservedWorkers.toString());
        }
    }
}
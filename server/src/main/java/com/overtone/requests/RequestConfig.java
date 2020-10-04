package com.overtone.requests;

import com.overtone.misc.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class RequestConfig extends RequestHeader {

  private String serverName;
  private List<String> supportedRequests;
  private final transient Logger log = LoggerFactory.getLogger(RequestConfig.class);

  public RequestConfig() {
    this.requestType = "config";
    this.requestVersion = RequestHeader.CURRENT_SUPPORTED_VERSION;
  }

  @Override
  public void buildResponse() {
    this.serverName = "Overtone Server";
    this.supportedRequests = new ArrayList();
    this.supportedRequests.add("config");
    log.trace("buildResponse -> {}", this);
  }

  public String getServerName() {
    return serverName;
  }

  public List<String> getSupportedRequests() {
    return supportedRequests;
  }
}
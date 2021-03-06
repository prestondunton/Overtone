package com.overtone.requests;

import com.overtone.requests.RequestConfig;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRequestConfig {

  private RequestConfig conf;

  @BeforeEach
  public void createConfigurationForTestCases(){
    conf = new RequestConfig();
    conf.buildResponse();
  }

  @Test
  @DisplayName("Request type is \"config\"")
  public void testType() {
    String type = conf.getRequestType();
    assertEquals("config", type);
  }

  @Test
  @DisplayName("Version number is equal to 1")
  public void testVersion() {
    int version = conf.getRequestVersion();
    assertEquals(1, version);
  }

  @Test
  @DisplayName("Server Name")
  public void testServerName() {
    String name = conf.getServerName();
    assertEquals("Overtone Server", name);
  }

  @Test
  @DisplayName("Supported Requests")
  public void testSupportedRequests() {
    List<String> supportedRequests = conf.getSupportedRequests();
    assertEquals(1, supportedRequests.size());
  }
}
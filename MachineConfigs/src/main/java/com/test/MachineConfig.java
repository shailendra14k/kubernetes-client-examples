package com.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.fabric8.kubernetes.client.CustomResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineConfig extends CustomResource {
   
}
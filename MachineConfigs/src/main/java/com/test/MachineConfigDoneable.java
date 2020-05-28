package com.test;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.client.CustomResourceDoneable;

public class MachineConfigDoneable extends CustomResourceDoneable<MachineConfig> {
    public MachineConfigDoneable(MachineConfig resource, Function<MachineConfig,MachineConfig> function) {
        super(resource, function);
    }
}
package com.test;

import java.util.stream.Collectors;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public class MainClass {

	public static void main(String[] args) {

		System.setProperty("kubeconfig", "~/.kube/kubeconfig");

		KubernetesClient client = new DefaultKubernetesClient();
		
		System.out.println("API URL = "+client.getMasterUrl());

		CustomResourceDefinition result = client.customResourceDefinitions()
				.withName("machineconfigs.machineconfiguration.openshift.io").get();

		MixedOperation<MachineConfig, MachineConfigList, MachineConfigDoneable, Resource<MachineConfig, MachineConfigDoneable>> result1 = client
				.customResources(result, MachineConfig.class, MachineConfigList.class, MachineConfigDoneable.class);

		System.out.println("+++++++++++++ List all machineconfigs Start ++++++++++++" );
		
		for (String temp : result1.list().getItems().stream().map(MachineConfig::getMetadata).map(ObjectMeta::getName)
				.collect(Collectors.toList())) {
			System.out.println(temp);
		}
		
		System.out.println("+++++++++++++ List all machineconfigs end ++++++++++++" );
		
	}

}

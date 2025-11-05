/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.opensearch.dataprepper.plugins.aws;

import io.micrometer.core.instrument.Counter;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.opensearch.dataprepper.metrics.PluginMetrics;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AwsSecretsManagerPluginMetricsTest {
    @Mock
    private PluginMetrics pluginMetrics;
    @Mock
    private Counter counter;

    @Test
    public void awsSecretsManagerPluginMetricsTest() {
        pluginMetrics = mock(PluginMetrics.class);
        when(pluginMetrics.counter(AwsSecretsManagerPluginMetrics.SECRETS_MANAGER_ACCESS_DENIED)).thenReturn(counter);
        when(pluginMetrics.counter(AwsSecretsManagerPluginMetrics.SECRETS_MANAGER_NOT_FOUND)).thenReturn(counter);
        when(pluginMetrics.counter(AwsSecretsManagerPluginMetrics.SECRETS_MANAGER_THROTTLED)).thenReturn(counter);

        AwsSecretsManagerPluginMetrics metrics = new AwsSecretsManagerPluginMetrics(pluginMetrics);

        assertThat(metrics.getSecretsManagerAccessDeniedCounter(), sameInstance(counter));
        assertThat(metrics.getSecretsManagerNotFoundCounter(), sameInstance(counter));
        assertThat(metrics.getSecretsManagerThrottledCounter(), sameInstance(counter));
    }
}
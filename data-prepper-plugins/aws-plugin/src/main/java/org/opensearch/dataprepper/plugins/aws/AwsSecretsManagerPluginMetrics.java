/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.opensearch.dataprepper.plugins.aws;

import io.micrometer.core.instrument.Counter;
import org.opensearch.dataprepper.metrics.PluginMetrics;

public class AwsSecretsManagerPluginMetrics {
    static final String SECRETS_MANAGER_ACCESS_DENIED = "secretsManagerAccessDenied";
    static final String SECRETS_MANAGER_NOT_FOUND = "secretsManagerNotFound";
    static final String SECRETS_MANAGER_THROTTLED = "secretsManagerThrottled";
    
    private final Counter secretsManagerAccessDeniedCounter;
    private final Counter secretsManagerNotFoundCounter;
    private final Counter secretsManagerThrottledCounter;

    public AwsSecretsManagerPluginMetrics(final PluginMetrics pluginMetrics) {
        secretsManagerAccessDeniedCounter = pluginMetrics.counter(SECRETS_MANAGER_ACCESS_DENIED);
        secretsManagerNotFoundCounter = pluginMetrics.counter(SECRETS_MANAGER_NOT_FOUND);
        secretsManagerThrottledCounter = pluginMetrics.counter(SECRETS_MANAGER_THROTTLED);
    }

    public Counter getSecretsManagerAccessDeniedCounter() {
        return secretsManagerAccessDeniedCounter;
    }

    public Counter getSecretsManagerNotFoundCounter() {
        return secretsManagerNotFoundCounter;
    }

    public Counter getSecretsManagerThrottledCounter() {
        return secretsManagerThrottledCounter;
    }
}
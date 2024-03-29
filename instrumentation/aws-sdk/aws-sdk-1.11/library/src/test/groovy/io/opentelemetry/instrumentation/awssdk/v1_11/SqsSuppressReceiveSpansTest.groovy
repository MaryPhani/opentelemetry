/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.awssdk.v1_11

import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import io.opentelemetry.instrumentation.test.LibraryTestTrait

class SqsSuppressReceiveSpansTest extends AbstractSqsSuppressReceiveSpansTest implements LibraryTestTrait {
  @Override
  AmazonSQSAsyncClientBuilder configureClient(AmazonSQSAsyncClientBuilder client) {
    return client.withRequestHandlers(
      AwsSdkTelemetry.builder(getOpenTelemetry())
        .setCaptureExperimentalSpanAttributes(true)
        .build()
        .newRequestHandler())
  }
}

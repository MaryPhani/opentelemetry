/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.tooling

import io.opentelemetry.api.GlobalOpenTelemetry
import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.api.events.GlobalEventEmitterProvider
import spock.lang.Specification

class OpenTelemetryInstallerTest extends Specification {

  void setup() {
    GlobalOpenTelemetry.resetForTest()
    GlobalEventEmitterProvider.resetForTest()
  }

  void cleanup() {
    GlobalOpenTelemetry.resetForTest()
    GlobalEventEmitterProvider.resetForTest()
  }

  def "should initialize GlobalOpenTelemetry"() {
    when:
    def autoConfiguredSdk = OpenTelemetryInstaller.installOpenTelemetrySdk(OpenTelemetryInstaller.classLoader)

    then:
    autoConfiguredSdk != null
    GlobalOpenTelemetry.get() != OpenTelemetry.noop()
  }

}

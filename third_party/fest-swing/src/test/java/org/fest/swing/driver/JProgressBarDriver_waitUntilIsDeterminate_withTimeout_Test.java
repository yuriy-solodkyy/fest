/*
 * Created on Dec 20, 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2009-2013 the original author or authors.
 */
package org.fest.swing.driver;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.driver.JProgressBarIndeterminateQuery.isIndeterminate;
import static org.fest.swing.driver.JProgressBarMakeDeterminateAsyncTask.makeDeterminate;
import static org.fest.swing.test.core.CommonAssertions.failWhenExpectingException;
import static org.fest.swing.timing.Timeout.timeout;

import org.fest.swing.exception.WaitTimedOutError;
import org.fest.swing.timing.Timeout;
import org.junit.Test;

/**
 * Tests for {@link JProgressBarDriver#waitUntilIsDeterminate(javax.swing.JProgressBar, Timeout)}.
 *
 * @author Alex Ruiz
 */
public class JProgressBarDriver_waitUntilIsDeterminate_withTimeout_Test extends JProgressBarDriver_TestCase {
  @Test(expected = NullPointerException.class)
  public void should_throw_error_if_timeout_is_null() {
    driver.waitUntilIsDeterminate(progressBar, null);
  }

  @Test
  public void should_wait_until_is_determinate() {
    makeIndeterminate();
    JProgressBarMakeDeterminateAsyncTask task = makeDeterminate(progressBar).after(1, SECONDS).createTask(robot);
    try {
      task.runAsynchronously();
      driver.waitUntilIsDeterminate(progressBar, timeout(2, SECONDS));
      assertThat(isIndeterminate(progressBar)).isEqualTo(false);
    } finally {
      task.cancelIfNotFinished();
    }
  }

  @Test
  public void should_time_out_if_determinate_state_never_reached() {
    makeIndeterminate();
    try {
      driver.waitUntilIsDeterminate(progressBar, timeout(1, MILLISECONDS));
      failWhenExpectingException();
    } catch (WaitTimedOutError e) {
      assertThat(e.getMessage()).contains("Timed out waiting for").contains("to be in determinate mode");
    }
  }
}

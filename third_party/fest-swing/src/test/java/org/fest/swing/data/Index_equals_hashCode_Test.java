/*
 * Created on Apr 30, 2009
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
 * Copyright @2009-2016 the FEST authors.
 */
package org.fest.swing.data;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link Index#equals(Object)} and {@link Index#hashCode()}.
 * 
 * @author Alex Ruiz
 */
public class Index_equals_hashCode_Test {
  private Index index;

  @Before
  public void setUp() {
    index = Index.atIndex(8);
  }

  @Test
  public void should_have_consistent_equals() {
    Index other = Index.atIndex(8);
    assertThat(index.equals(other)).isTrue();
  }

  @Test
  public void should_have_reflexive_equals() {
    assertThat(index).isEqualTo(index);
  }

  @Test
  public void should_have_symmetric_equals() {
    Index other = Index.atIndex(8);
    assertThat(other).isEqualTo(index);
    assertThat(index).isEqualTo(other);
  }

  @Test
  public void should_have_transitive_equals() {
    Index other1 = Index.atIndex(8);
    Index other2 = Index.atIndex(8);
    assertThat(other1).isEqualTo(index);
    assertThat(other2).isEqualTo(other1);
    assertThat(other2).isEqualTo(index);
  }

  @Test
  public void should_maintain_equals_and_hashCode_contract() {
    Index other = Index.atIndex(8);
    assertThat(other).isEqualTo(index);
    assertThat(other.hashCode()).isEqualTo(index.hashCode());
  }

  @Test
  public void should_not_be_equal_to_null() {
    assertThat(index.equals(null)).isFalse();
  }

  @Test
  public void should_not_be_equal_to_Object_not_being_of_same_type() {
    assertThat(index.equals("Hello")).isFalse();
  }

  @Test
  public void should_return_not_equal_if_index_values_are_not_equal() {
    Index other = Index.atIndex(6);
    assertThat(index.equals(other)).isFalse();
  }

  public void should_not_be_equal_to_Object_of_different_type() {
    // TODO Auto-generated method stub

  }

  public void equals_should_be_consistent() {
    // TODO Auto-generated method stub

  }

  public void equals_should_be_reflexive() {
    // TODO Auto-generated method stub

  }

  public void equals_should_be_symmetric() {
    // TODO Auto-generated method stub

  }

  public void equals_should_be_transitive() {
    // TODO Auto-generated method stub

  }
}

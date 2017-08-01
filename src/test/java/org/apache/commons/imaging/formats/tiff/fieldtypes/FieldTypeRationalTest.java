/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.imaging.formats.tiff.fieldtypes;

import org.apache.commons.imaging.ImageWriteException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.nio.ByteOrder;
import org.apache.commons.imaging.common.RationalNumber;
import org.apache.commons.imaging.formats.tiff.TiffField;

/**
 * Unit tests for class {@link FieldTypeRational}.
 *
 * @date 2017-08-01
 * @see FieldTypeRational
 *
 **/
public class FieldTypeRationalTest{

  @Test
  public void testWriteDataWithNull() throws ImageWriteException {
      FieldTypeRational fieldTypeRational = new FieldTypeRational(9, null);
      Double doubleOne = new Double(2.2);
      byte[] byteArray = fieldTypeRational.writeData(doubleOne, null);

      assertArrayEquals(new byte[] {(byte)11, (byte)0, (byte)0, (byte)0, (byte)5, (byte)0, (byte)0, (byte)0}, byteArray);
  }

  @Test(expected = ImageWriteException.class)
  public void testWriteDataWithNonNull() throws ImageWriteException {
      FieldTypeRational fieldTypeRational = new FieldTypeRational((-922), "z_AX");
      ByteOrder byteOrder = ByteOrder.nativeOrder();

      fieldTypeRational.writeData("z_AX", byteOrder);

  }

}
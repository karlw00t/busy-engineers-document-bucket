// CHECKSTYLE:OFF MissingJavadocMethod
// TODO https://github.com/aws-samples/busy-engineers-document-bucket/issues/24

package sfw.example.esdkworkshop.datamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class DocumentBundle {
  private final PointerItem pointer;
  private final byte[] data;

  DocumentBundle(byte[] data, PointerItem pointer) {
    this.pointer = pointer;
    this.data = Arrays.copyOf(data, data.length);
  }

  public static DocumentBundle fromData(byte[] data) {
    return fromDataAndContext(data, Collections.emptyMap());
  }

  public static DocumentBundle fromDataAndPointer(byte[] data, PointerItem pointer) {
    return new DocumentBundle(data, pointer);
  }

  public static DocumentBundle fromDataAndContext(byte[] data, Map<String, String> context) {
    return new DocumentBundle(data, PointerItem.generate(context));
  }

  public byte[] getData() {
    return Arrays.copyOf(data, data.length);
  }

  public PointerItem getPointer() {
    return pointer;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder(pointer.toString());
    b.append(System.getProperty("line.separator"));
    b.append("Data: {");
    for (int i = 0; i < data.length; i++) {
      b.append(String.format("%X", data[i]));
    }
    b.append("}");
    return b.toString();
  }
}

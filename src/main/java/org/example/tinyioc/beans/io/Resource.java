package org.example.tinyioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是Spring内部定位资源的接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}

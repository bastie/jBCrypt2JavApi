package org.mindrot;

import java.lang.reflect.Method;

// Permission to use, copy, modify, and distribute this software for any
// purpose with or without fee is hereby granted, provided that the above
// copyright notice and this permission notice appear in all copies.
//
// THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
// WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
// ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
// WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
// ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
// OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.

import junit.framework.TestCase;

public class TestBCryptBase64 extends TestCase {

  public void testBase64Impl () {
    try {
      System.out.println ("BCrypt.base64 implementation");
      Method m  = BCryptBase64.Encoder.class.getDeclaredMethod ("encode", byte[].class, int.class);
      m.setAccessible (true);
      byte[] content = "BCrypt.base64 encoding".getBytes ("UTF-8");
      int size = content.length;
      Object result = m.invoke (null, content,size);
      String actually = (String) result;
      String expected = "OiLwcV/yJkHfa0S0LA/jZkLtXEjsXu";
      assertEquals (actually, expected);
      
      content = "BCrypt.base64 encoding?".getBytes ("UTF-8");
      size = content.length;
      result = m.invoke (null, content,size);
      actually = (String) result;
      expected = "OiLwcV/yJkHfa0S0LA/jZkLtXEjsXx6";
      //System.out.println (actually);
      assertEquals (actually, expected);
      
    }
    catch (Throwable shit) {
      assertFalse(true);
    }
  }

}

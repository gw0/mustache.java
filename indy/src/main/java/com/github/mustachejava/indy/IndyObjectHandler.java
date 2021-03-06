package com.github.mustachejava.indy;

import com.github.mustachejava.reflect.ReflectionObjectHandler;
import com.github.mustachejava.reflect.ReflectionWrapper;
import com.github.mustachejava.util.Wrapper;
import org.objectweb.asm.Opcodes;

/**
 * Creates custom classes instead of using reflection for handling objects. Leverages
 * the ReflectionObjectHandler to create the original wrappers and converts them to
 * new versions.
 */
public class IndyObjectHandler extends ReflectionObjectHandler implements Opcodes {

  @Override
  public Wrapper find(String name, Object[] scopes) {
    Wrapper wrapper = super.find(name, scopes);
    if (wrapper instanceof ReflectionWrapper) {
      ReflectionWrapper rw = (ReflectionWrapper) wrapper;
      return IndyWrapper.create(rw);
    } else {
      return wrapper;
    }
  }
}

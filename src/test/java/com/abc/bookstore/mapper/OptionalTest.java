package com.abc.bookstore.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionalTest {
    @Test
    public void testGetOptional(){
        Foo foo =new Foo("10");
        Optional<Foo> fooOptional = Optional.of(foo);
        fooOptional.ifPresent(x-> System.out.println(x.getVal()));
        fooOptional.orElseGet(Foo::new);

    }
    @Test
    public void testOptionOr(){
        Foo foo =new Foo("10");
        Optional<Foo> fooOptional = Optional.ofNullable(foo);
        fooOptional.or(()->Optional.of(new Foo()));


    }

   @Test
    public void testConvertToOptionalWithGet(){
        Foo foo = new Foo();
        foo.setVal("test");
        Optional<Foo> fooOptional = Optional.of(foo);
        Assertions.assertEquals("test",fooOptional.get().getVal());
    }
    @Test
    public void testConvertToOptionalOfWithGetNullValue(){
        // this will throw NULL pointer exception
        Foo foo = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Optional<Foo> fooOptional = Optional.of(foo);
        });
        Assertions.assertEquals(foo,exception.getMessage());
    }

    @Test
    public void testOptionalConvertToOptionalWithGetNullable(){
        Foo foo = new Foo();
        foo.setVal("test");
        Optional<Foo> fooOptional = Optional.of(foo);
        fooOptional.ifPresent(x-> System.out.println(x.val));
    }

    class Foo{
        private String val;

        public Foo(String val) {
            this.val = val;
        }
        public Foo() {
            System.out.println("Foo called");
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
        public Foo getInstance(){
            return new Foo();
        }
    }
}

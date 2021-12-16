package cl.jlgajardo.pruebatecnica.repository.core;


import java.util.stream.Stream;

public interface Invokable {

    SPResponse create(Stream<InputSPParam> inputParams);

    <T> SPResponse insert(T inputParams);

    SPResponse query(Stream<InputSPParam> inputParams);

    <T> SPResponse query(T inputParams);
}

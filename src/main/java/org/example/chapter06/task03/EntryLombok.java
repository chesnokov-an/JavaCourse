package org.example.chapter06.task03;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class EntryLombok<K, V> {
    private K key;
    private V value;
}

package com.imooc.testmy;

/**
 * stream常见操作api介绍
 * 1.聚合操作
 *
 * 2.stream的处理流程
 *      数据源
 *      数据转换
 *      获取结果
 *
 * 3. 获取stream对象
 *      1.从集合或者数组中获取
 *          Collection.stream(),如accounts.stream()
 *          Collection.parallelStream()
 *          Arrays.stream(T t)
 *      2. BufferReader
 *          BufferReader.lines() -> stream()
 *      3. 静态工程
 *          java.util.stream.IntStream.range()..
 *          java.nio.file.Files.wali()..
 *      4.自定构建
 *          java.util.Spliterator
 *      5.更多的方法
 *
 * 4.中间操作API{intermediate}
 *      操作结果是一个Stream,中间操作可以又一个或者多个连续的中间操作，
 *      需要注意的是，中间操作只记录操作方式，不做具体执行，
 *      直到结束操作发生时，才做数据的最终执行。
 *      中间操作：就是业务逻辑处理。
 *   中间操作过程：无状态：数据处理时，不受前置中间操作的影响
 *                      map/filter/peek/parallel/sequential/unordered
 *                有状态：数据处理时，受到牵制中间操作的影响
 *                      distinct/sorted/limit/skip
 * 5.中介操作\结束操作{Terminal}
 *      需要注意：一个Stream对象，只能有一个Terminal操作，
 *      这个操作一旦发生，就会真是处理数据，生成对应的处理结果。
 *      中介操作：非短路操作：处理完所有才会有结果。
 *                  forEach/forEachOrdered/toArray/reduce/collect/min/max/count/iterator
 *                短路操作：一旦满足某个条件就有结果。
 *                  anyMatch/allMach/noneMatch/findFirst/findAny等
 *                  Short-circuiting,无限大的Stream-> 有限大的Stream
 *
 */
public class Test3 {


}

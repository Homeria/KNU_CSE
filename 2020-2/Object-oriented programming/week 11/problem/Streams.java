package w11.problem;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This set of exercises covers simple stream pipelines,
 * including intermediate operations and basic collectors.
 *
 * Some of these exercises use a BufferedReader variable
 * named "reader" that the test has set up for you.
 */

public class Streams {
    /**
     * Given a list of words, create an output list that contains
     * only the odd-length words, converted to upper case.
     */
    @Test 
    public void d1_upcaseOddLengthWords() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        List<String> result = input.stream()
        		.filter(w -> (w.length() % 2) == 1)
        		.map(String::toUpperCase)
        		.collect(Collectors.toList());
        assertEquals(List.of("BRAVO", "CHARLIE", "DELTA", "FOXTROT"), result);
        
    }
    
    // Hint 1:
    // Use filter() and map().
    // Hint 2:
    // To create the result list, use collect() with one of the
    // predefined collectors on the Collectors class.


    /**
     * Take the third through fifth words of the list, extract the
     * second letter from each, and join them, separated by commas,
     * into a single string. 
     * Watch for off-by-one errors. (한칸씩 어긋나는 에러를 조심하시오.)
     */
    @Test 
    public void d2_joinStreamRange() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        String result = input.stream()
        		.skip(2)
        		.limit(3)
        		.map(w -> w.charAt(1))
        		.map(Object::toString)
        		.collect(Collectors.joining(","));

        assertEquals("h,e,c", result);
    }
    // Hint 1:
    // Use Stream.skip() and Stream.limit().
    // Hint 2:
    // Use Collectors.joining().


    /**
     * Count the number of lines in the text file. 
     * 
     * (Remember to use the BufferedReader named "reader" 
     * that has already been opened for you.
     * "reader"라는 이름의 BufferedReader가 이미 열려 있으니
     * 이것을 사용하면 됩니다.)
     * 
     * 이 파일의 맨 끝에 @Before 아노테이션이 붙어 있는
     * 메소드와 @After 아노테이션이 붙어 있는 메소드가 있습니다.
     * 각 @Test 메소드가 실행되기 전에 @Before 메소드가 먼저 실행되고
     * @Test 메소드 실행 후에 @After 메소드가 실행됩니다.)
     * 
     * @throws IOException
     */
    @Test 
    public void d3_countLinesInFile() throws IOException {
        
    	long count = reader.lines().count();

        assertEquals(14, count);
    }
    // Hint 1:
    // Use BufferedReader.lines() to get a stream of lines.
    // Hint 2:
    // Use Stream.count().


    /**
     * Find the length of the longest line in the text file.
     *
     * @throws IOException
     */
    @Test 
    public void d4_findLengthOfLongestLine() throws IOException {
        
    	int longestLength = reader
    			.lines()
    			.mapToInt(w -> w.length())
    			.max()
    			.orElse(-1);

        assertEquals(53, longestLength);
    }
    // Hint 1:
    // Use Stream.mapToInt() to convert a stream of objects to an IntStream.
    // Hint 2:
    // Look at java.util.OptionalInt to get the result.
    // Hint 3:
    // Think about the case where the OptionalInt might be empty
    // (that is, where it has no value). 이런 경우에는 -1을 반환하게 하세요.


    /**
     * Find the longest line in the text file.
     *
     * @throws IOException
     */
    @Test 
    public void d5_findLongestLine() throws IOException {
        String longest = reader
        		.lines()
        		.max(Comparator.comparing(String::length))
        		.orElseThrow();

        assertEquals("Feed'st thy light's flame with self-substantial fuel,", longest);
    }
    // Hint 1:
    // Use Stream.max() with a Comparator..
    // Hint 2:
    // Use static methods on Comparator to help create a Comparator instance.


    /**
     * Select the longest words from the input list. That is, select the words
     * whose lengths are equal to the maximum word length.
     */
    @Test 
    public void d6_selectLongestWords() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");
        List<String> result = input.stream()
        		.filter(w -> (w.length()) == input.stream().mapToInt(j -> j.length()).max().orElse(-1))
        		.collect(Collectors.toList());

        assertEquals(List.of("charlie", "foxtrot"), result);
    }
    // Hint:
    // Consider making two passes over the input stream.
    // 두 문장으로 작성하는 편이 좋습니다.
    // 첫 문장에서는 가장 긴 단어를 길이를 알아냅니다.
    // 두 번째 문장에서는 그 길이를 갖는 단어 리스트를 구합니다.

    /**
     * Select the list of words from the input list whose length is greater than
     * the word's position in the list (starting from zero) .
     */
    @Test 
    public void d7_selectByLengthAndPosition() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

        List<String> result = null; // TODO
        result = IntStream.range(0, input.size())
        		.filter(i -> input.get(i).length() > i)
        		.mapToObj(i -> input.get(i))
        		.collect(Collectors.toList());

        assertEquals(List.of("alfa", "bravo", "charlie", "delta", "foxtrot"), result);
    }
    // Hint:
    // Instead of a stream of words (Strings), run an IntStream of indexes of
    // the input list, using index values to get elements from the input list.
    // 0번째 단어 길이가 0보다 큰가? 1번 단어 길이가 1보다 큰가? 2번 단어 길이가 2보다 큰가? 이런 식으로 풀면 됩니다.
    // IntStream을 가지고 작업합니다. 해당되는 번호의 단어만을 input에서 골라 리스트에 모으면 됩니다.


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================


    private BufferedReader reader;

    @Before
    public void z_setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8);
    }

    @After
    public void z_closeBufferedReader() throws IOException {
        reader.close();
    }

}
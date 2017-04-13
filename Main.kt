
import java.util.*

/**
 * Created by jason on 4/10/17.
 */
fun main(args: Array<String>) {
  // setup
  var numbers = mutableListOf(1, 3, 34, 4, 5, 7, 2)
  println(findKthLargestElement(3, numbers))
}

fun returnOddCountItem(a: List<Int>): Int {
  var map = mutableMapOf<Int, Int>()
  for (x in a) {
    if (map.containsKey(x)) {
      var value = map.get(x)
      if (value != null) {
        value += 1
        map.put(x, value)
      }
    } else {
      map.put(x, 1)
    }
  }

  return map.entries
      .firstOrNull { it.value % 2 == 1 }
      ?.key
      ?: -1;
}

fun quickSort(a: List<Int>, low: Int, high: Int) {
  if (low < high) {
    var index = partition(a, low, high)
    quickSort(a, low, index - 1)
    quickSort(a, index + 1, high)
  }
}

fun partition(a: List<Int>, low: Int, high: Int): Int {
  var pivot = a[high]
  var i = low - 1

  for (j in low..high - 1){
    if (a[j] <= pivot){
      i = i + 1
      Collections.swap(a, i, j)
    }
  }

  Collections.swap(a, i + 1, high)
  return i + 1
}

// Merge K sorted Arrays
// find Kth largest element in unsorted array in 0(n) time complexity
fun findKthLargestElement(k: Int, a: List<Int>): Int {
  var b = mutableListOf<Int>()
  quickSelect(a, 0, a.size - 1, k, b)
  return b[0]
}


fun quickSelect(a: List<Int>, low: Int, high: Int, k: Int, b: MutableCollection<Int>) {
  if (low < high) {
    var index = partition(a, low, high)

    if (k == a.size - index){
      b.add(a[index])
      return
    }

    if (b.isEmpty()) quickSelect(a, low, index - 1, k, b)
    if (b.isEmpty()) quickSelect(a, index + 1, high, k, b)
  }
}
// find median element from stream
// check if tree is balanced
// check if tree is the same
// check if tree is mirror

fun maximumSubArray(a: List<Int>): Int{
  var maxEndingHere = 0
  var maxSoFar = 0
  for (num in a){
    maxEndingHere = Math.max(num, maxEndingHere + num)
    maxSoFar = Math.max(maxSoFar, maxEndingHere)
  }
  return maxSoFar
}

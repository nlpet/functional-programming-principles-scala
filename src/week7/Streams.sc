

def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)

((1000 to 10000).toStream filter isPrime)(1)


/* Streams dont follow the cons operator but
 * the alternative operator is #::
 * x #:: xs == Stream.cons(x, xs)
 */


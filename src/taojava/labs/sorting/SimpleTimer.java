package taojava.labs.sorting;

/**
 * A simple timer.  Computes time in milliseconds.  The normal sequence is
 * <pre>
 *    // Create the new timer.  The timer is not yet running.
 *    SimpleTimer t = new SimpleTimer();    
 *    // Start the timer running.
 *    t.start();
 *    ...
 *    // Pause the timer (e.g., to do some output that we don't want to count).
 *    t.pause();
 *    ...
 *    // Resume the timer.
 *    t.resume();
 *    ...
 *    // Find out how much time has elapsed without stopping the timer.
 *    long time = t.elapsed();
 *    ...
 *    // Reset and stop the timer.
 *    t.reset();
 * </pre>
 */
public class SimpleTimer
{
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The most recent time the timer was started.  Set to 0 when
   * the timer is not yet started.
   */
  long started;

  /**
   * The accumulated time.
   */
  long elapsed;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new timer.
   */
  public SimpleTimer()
  {
    this.started = 0;
    this.elapsed = 0;
  } // SimpleTimer()

  // +-----------+---------------------------------------------------
  // | Observers |
  // +-----------+

  /**
   * Get the elapsed time.
   */
  public long elapsed()
  {
    if (this.started == 0)
      return this.elapsed;
    else
      return this.elapsed + (System.currentTimeMillis()-this.started);
  } // elapsed()

  // +----------+----------------------------------------------------
  // | Mutators |
  // +----------+

  /**
   * Pause the timer.
   */
  public void pause()
  {
    long now = System.currentTimeMillis();
    // Update our ellapsed time, if appropriate.
    if (this.started != 0)
      this.elapsed += now - this.started;
    // Note that the timer is not running.
    this.started = 0;
  } // pause()

  /**
   * Reset the timer.  Resetting also stops the timer.
   */
  public void reset()
  {
    this.elapsed = 0;
    this.started = 0;
  } // reset()

  /**
   * Resume the timer.
   */
  public void resume()
  {
    this.started = System.currentTimeMillis();
  } // resume()

  /**
   * Start the timer.
   */
  public void start()
  {
    // Record the time it starts.
    this.started = System.currentTimeMillis();
  } // start()

} // class SimpleTimer

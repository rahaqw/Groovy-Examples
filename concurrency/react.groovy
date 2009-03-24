import static org.gparallelizer.actors.pooledActors.PooledActors.*
 
def me = actor {
    friend.send('Hi')
    react(10.seconds) {message ->
        //continue conversation
    }
}
 
me.metaClass.onTimeout = {->friend.send('I see, busy as usual. Never mind.')}
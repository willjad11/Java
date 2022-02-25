// DLLNodes have a .next and .prev
class DLLNode {
    constructor(data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// DLLists have both a .head and .tail pointer
class DLList {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    // == Main Methods ==

    // add node before target
    // target is the value of a node in the list
    // consider the edge case where you may have to move the head
    // consider the edge case where you do not find the target
    prepend(target, node) {
        let runner = this.head;
        if (this.head && target === this.head.data) {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            return true;
        }
        while (runner) {
            if (runner.data === target) {
                node.prev = runner.prev;
                runner.prev.next = node;
                runner.prev = node;
                node.next = runner;
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    // return true or false if a node exists with data === val
    exists(val) {
        let runnerFront = this.head;
        let runnerBack = this.tail;
        while (runnerFront != runnerBack) {
            if (runnerFront.data === val || runnerBack.data === val) {
                return true;
            }
            runnerFront = runnerFront.next;
            runnerBack = runnerBack.prev;
        }
        return false;
    }

    // push to head
    addHead(node) {
        if (!this.head) { // empty list
            this.head = node;
            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }

    // pop from tail
    removeTail() {
        if (this.head == null) return; // empty list
        if (this.head === this.tail) { // one node
            var temp = this.tail; // set a temp
            this.head = null; // disconnect the head
            this.tail = null; // disconnect the tail
            return temp;
        }
        var temp = this.tail; // set a temp
        this.tail = tail.prev; // move the tail back
        this.tail.next = null; // null out the new tail's next
        temp.prev = null; // null out the temp's prev
        return temp;
    }

    print() {
        let runner = this.head;
        while (runner) {
            console.log(runner.data)
            runner = runner.next;
        }
    }

    // return is empty
    isEmpty() {
        return this.head === null;
    }

    // == Bonus Methods, just inverted versions of the first set ==

    // push to tail
    addTail(node) { }

    // pop from head
    removeHead() { }
}

// instantiate the DLL
// add a few nodes
// test!

let myDLL = new DLList();
let newDLL = new DLList();

myDLL.addHead(new DLLNode(5));
myDLL.addHead(new DLLNode(4));
myDLL.addHead(new DLLNode(3));
myDLL.addHead(new DLLNode(2));
myDLL.addHead(new DLLNode(1));

myDLL.prepend(3, new DLLNode(8000));
myDLL.print();
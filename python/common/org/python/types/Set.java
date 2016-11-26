package org.python.types;

public class Set extends org.python.types.Object {
    public java.util.Set<org.python.Object> value;

    /**
     * A utility method to update the internal value of this object.
     *
     * Used by __i*__ operations to do an in-place operation.
     * obj must be of type org.python.types.Set
     */
    void setValue(org.python.Object obj) {
        this.value = ((org.python.types.Set) obj).value;
    }

    public java.lang.Object toJava() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public org.python.Object __hash__() {
        throw new org.python.exceptions.AttributeError(this, "__hash__");
    }

    public Set() {
        super();
        this.value = new java.util.HashSet<org.python.Object>();
    }

    public Set(java.util.Set<org.python.Object> set) {
        super();
        this.value = set;
    }

    // public org.python.Object __new__() {
    //     throw new org.python.exceptions.NotImplementedError("__new__() has not been implemented");
    // }

    // public org.python.Object __init__() {
    //     throw new org.python.exceptions.NotImplementedError("__init__() has not been implemented");
    // }


    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __repr__() {
        // Representation of an empty set is different
        if (this.value.size() == 0) {
            return new org.python.types.Str("set()");
        }

        java.lang.StringBuilder buffer = new java.lang.StringBuilder("{");
        boolean first = true;
        for (org.python.Object obj: this.value) {
            if (first) {
                first = false;
            } else {
                buffer.append(", ");
            }
            buffer.append(obj.__repr__());
        }
        buffer.append("}");
        return new org.python.types.Str(buffer.toString());
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Str __format__(org.python.Object format_string) {
        throw new org.python.exceptions.NotImplementedError("__format__() has not been implemented");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __getitem__(org.python.Object index) {
        if (index instanceof org.python.types.Int || index instanceof org.python.types.Bool) {
            throw new org.python.exceptions.TypeError("'set' object does not support indexing");
        } else {
            throw new org.python.exceptions.TypeError("'set' object is not subscriptable");
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __lt__(org.python.Object other) {
        if (other instanceof org.python.types.Set) {
            org.python.types.Set otherSet = (org.python.types.Set) other;
            return new org.python.types.Bool(otherSet.value.containsAll(this.value) && !this.value.equals(otherSet.value));
        }
        throw new org.python.exceptions.TypeError(
            String.format("unorderable types: set() < %s()",
                org.Python.typeName(other.getClass())));
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __le__(org.python.Object other) {
        if (other instanceof org.python.types.Set) {
            org.python.types.Set otherSet = (org.python.types.Set) other;
            return new org.python.types.Bool(otherSet.value.containsAll(this.value));
        }
        throw new org.python.exceptions.TypeError(
            String.format("unorderable types: set() <= %s()",
                org.Python.typeName(other.getClass())));
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __eq__(org.python.Object other) {
        boolean eq = false;
        if (other instanceof org.python.types.Set) {
            org.python.types.Set otherSet = (org.python.types.Set) other;
            eq = this.value.equals(otherSet.value);
        }
        return new org.python.types.Bool(eq);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __ne__(org.python.Object other) {
        return new org.python.types.Bool(!((org.python.types.Bool) this.__eq__(other)).value);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __gt__(org.python.Object other) {
        if (other instanceof org.python.types.Set) {
            org.python.types.Set otherSet = (org.python.types.Set) other;
            return new org.python.types.Bool(this.value.containsAll(otherSet.value) && !this.value.equals(otherSet.value));
        }
        throw new org.python.exceptions.TypeError(
            String.format("unorderable types: set() > %s()",
                org.Python.typeName(other.getClass())));
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __ge__(org.python.Object other) {
        if (other instanceof org.python.types.Set) {
            org.python.types.Set otherSet = (org.python.types.Set) other;
            return new org.python.types.Bool(this.value.containsAll(otherSet.value));
        }
        throw new org.python.exceptions.TypeError(
            String.format("unorderable types: set() >= %s()",
                org.Python.typeName(other.getClass())));
    }

    public boolean __setattr_null(java.lang.String name, org.python.Object value) {
        // Builtin types can't have attributes set on them.
        return false;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Bool __bool__() {
        return new org.python.types.Bool(this.value.size() > 0);
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __invert__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary ~: 'set'");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __pos__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary +: 'set'");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __neg__() {
        throw new org.python.exceptions.TypeError("bad operand type for unary -: 'set'");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.List __dir__() {
        throw new org.python.exceptions.NotImplementedError("__dir__() has not been implemented");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.types.Int __len__() {
        return new org.python.types.Int(this.value.size());
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Iterable __iter__() {
        throw new org.python.exceptions.NotImplementedError("__iter__() has not been implemented");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __contains__(org.python.Object other) {
        return new org.python.types.Bool(this.value.contains(other));
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __not_contains__(org.python.Object other) {
        return new org.python.types.Bool(!this.value.contains(other));
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __mul__(org.python.Object other) {
        if (other instanceof org.python.types.List) {
            throw new org.python.exceptions.TypeError("can't multiply sequence by non-int of type '" + this.typeName() + "'");
        } else if (other instanceof org.python.types.Tuple) {
            throw new org.python.exceptions.TypeError("can't multiply sequence by non-int of type '" + this.typeName() + "'");
        } else if (other instanceof org.python.types.Str) {
            throw new org.python.exceptions.TypeError("can't multiply sequence by non-int of type '" + this.typeName() + "'");
        }
        return super.__mul__(other);
    }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __sub__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__sub__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __and__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__and__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __xor__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__xor__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __or__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__or__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __rsub__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__rsub__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __rand__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__rand__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __rxor__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__rxor__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public org.python.Object __ror__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__ror__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public void __isub__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__isub__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public void __iand__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__iand__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public void __ixor__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__ixor__() has not been implemented");
    // }

    // @org.python.Method(
    //     __doc__ = ""
    // )
    // public void __ior__(org.python.Object other) {
    //     throw new org.python.exceptions.NotImplementedError("__ior__() has not been implemented");
    // }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object add(org.python.Object other) {
        this.value.add(other);
        return org.python.types.NoneType.NONE;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object clear() {
        this.value.clear();
        return org.python.types.NoneType.NONE;
    }

    @org.python.Method(
        __doc__ = "Return a shallow copy of a set."
    )
    public org.python.Object copy() {
        return new Set(new java.util.HashSet<org.python.Object>(this.value));
    }

    @org.python.Method(
        __doc__ = "Return the difference of two or more sets as a new set.\n\n(i.e. all elements that are in this set but not the others.)",
        args = {"other"}
    )
    public org.python.Object difference(org.python.Object other) {
        java.util.Set set = ((Set) this.copy()).value;
        set.removeAll(((Set) other).value);
        return new Set(set);
    }

    @org.python.Method(
        __doc__ = "Remove all elements of another set from this set.",
        args = {"other"}
    )
    public org.python.Object difference_update(org.python.Object other) {
        this.value.removeAll(((Set) other).value);
        return org.python.types.NoneType.NONE;
    }

    @org.python.Method(
        __doc__ = "Remove an element from a set if it is a member.\n\nIf the element is not a member, do nothing.",
        args = {"item"}
    )
    public org.python.Object discard(org.python.Object item) {
        this.value.remove(item);
        return org.python.types.NoneType.NONE;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object __iadd__(org.python.Object other) {
        throw new org.python.exceptions.TypeError("unsupported operand type(s) for +=: 'set' and '" + other.typeName() + "'");
    }

    @org.python.Method(
        __doc__ = "Return the intersection of two sets as a new set.\n\n(i.e. all elements that are in both sets.)",
        args = {"other"}
    )
    public org.python.Object intersection(org.python.Object other) {
        java.util.Set set = ((Set) this.copy()).value;
        set.retainAll(((Set) other).value);
        return new Set(set);
    }

    @org.python.Method(
        __doc__ = "Update a set with the intersection of itself and another.",
        args = {"other"}
    )
    public org.python.Object intersection_update(org.python.Object other) {
        this.value.retainAll(((Set) other).value);
        return org.python.types.NoneType.NONE;
    }

    @org.python.Method(
        __doc__ = "Return True if two sets have a null intersection.",
        args = {"other"}
    )
    public org.python.Object isdisjoint(org.python.Object other) {
        return new Bool( ((Int) this.intersection(other).__len__()).value == 0) ;
    }

    @org.python.Method(
        __doc__ = "Report whether another set contains this set.",
        args = {"other"}
    )
    public org.python.Object issubset(org.python.Object other) {
        return new Bool( ((java.util.Set) other.toJava()).containsAll((java.util.Set) this.toJava()) );
    }

    @org.python.Method(
        __doc__ = "Report whether this set contains another set.",
        args = {"other"}
    )
    public org.python.Object issuperset(org.python.Object other) {
        return new Bool( ((java.util.Set) this.toJava()).containsAll((java.util.Set) other.toJava()) );

    }

    @org.python.Method(
            __doc__ = "",
            args = {}
    )
    public org.python.Object pop() {
        if (this.value.size() == 0) {
            throw new org.python.exceptions.KeyError(new org.python.types.Str("pop from an empty set"));
        }

        java.util.Iterator<org.python.Object> iterator = this.value.iterator();
        org.python.Object popped = iterator.next();
        iterator.remove();

        return popped;
    }

    @org.python.Method(
        __doc__ = "Remove an element from a set; it must be a member.\n\nIf the element is not a member, raise a KeyError.",
        args = {"item"}
    )
    public org.python.Object remove(org.python.Object item) {
        if (!this.value.remove(item)) {
            throw new org.python.exceptions.KeyError(item);
        }
        return org.python.types.NoneType.NONE;
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object symmetric_difference(org.python.Object other) {
        throw new org.python.exceptions.NotImplementedError("symmetric_difference() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = ""
    )
    public org.python.Object symmetric_difference_update(org.python.Object other) {
        throw new org.python.exceptions.NotImplementedError("symmetric_difference_update() has not been implemented.");
    }

    @org.python.Method(
        __doc__ = "Return the union of sets as a new set.\n\n(i.e. all elements that are in either set.)",
        args = {"other"}
    )
    public org.python.Object union(org.python.Object other) {
        java.util.Set set = ((Set) this.copy()).value;
        set.addAll(((Set) other).value);
        return new Set(set);
    }

    @org.python.Method(
        __doc__ = "Update a set with the union of itself and others.",
        args = {"other"}
    )
    public org.python.Object update(org.python.Object other) {
        this.value.addAll(((Set) other).value);
        return org.python.types.NoneType.NONE;
    }
}

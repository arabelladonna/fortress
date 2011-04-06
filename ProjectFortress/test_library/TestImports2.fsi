(*******************************************************************************
    Copyright 2008, Oracle and/or its affiliates.
    All rights reserved.


    Use is subject to license terms.

    This distribution may include materials developed by third parties.

 ******************************************************************************)

api TestImports2

trait S
  myname():String
  s():String
end

trait T extends S
  t():String
end

trait U extends T
  u():String
end

object V extends U
  myname():String
end

end

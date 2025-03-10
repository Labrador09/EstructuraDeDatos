import pandas as pd
import regex as re # type: ignore

test = "67+Joy$% an,.2"
result = re.findall("\.",test)

print(result)